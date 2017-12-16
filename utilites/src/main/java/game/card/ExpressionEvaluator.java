package game.card;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExpressionEvaluator {

    public static Stack<Integer> numbers(final String in) {
        return parse(in, StringUtils::isNumeric, Integer::valueOf);
    }

    public static Stack<String> operators(final String in) {
        return parse(in, operatorPredicate(), String::toString);
    }

    public static Integer doOp(Integer left, Integer right, String op) {
        if (op.contains("+"))
            return left + right;
        if (op.contains("*"))
            return left * right;
        return 0;
    }

    public static SResult doMath(Stack<Integer> numbers, Stack<String> operators) {
        Integer result = 0;
        Stack<Integer> rs = new Stack<>();
        Stack<String> ops = new Stack<>();
        while (!operators.empty()) {
            String op = operators.pop();
            if (op.contains(")")) {
                op = operators.pop();
                boolean f = false;
                while (!op.contains("(")) {
                    f = true;
                    op = operators.pop();
                    Integer r = numbers.pop();
                    Integer l = numbers.pop();
                    numbers.push(r + l);
                }
                if (f) {
                    rs.push(numbers.pop());
                    if (operators.size() > 0)
                        ops.push(operators.pop());
                    return new SResult(rs, ops).other(numbers, operators);
                }
            }

        }
        return null;
    }

    public static Integer simple(Stack<Integer> numbers, Stack<String> operators) {
        while (numbers.size() > 1) {
            Integer r = numbers.pop();
            Integer l = numbers.pop();
            String op = operators.pop();
            if (op.contains("*")) {
                numbers.push(l * r);
            } else {
                numbers.push(l + r);
            }
        }
        return numbers.pop();
    }

    public static class SResult {
        public Stack<Integer> rs = new Stack<>();
        public Stack<String> ops = new Stack<>();

        public Stack<Integer> otherRs = new Stack<>();
        public Stack<String> otherOps = new Stack<>();

        public SResult(Stack<Integer> rs, Stack<String> ops) {
            this.rs = rs;
            this.ops = ops;
        }

        public SResult other(Stack<Integer> rs, Stack<String> ops) {
            this.otherRs = rs;
            this.otherOps = ops;
            return this;
        }

        public SResult merge(SResult other) {
            rs.addAll(other.rs);
            ops.addAll(other.ops);
            return this;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) return false;
            SResult sResult = (SResult) o;
            if (sResult.rs.size() != this.rs.size()
                    || sResult.ops.size() != this.ops.size()
                    ) {
                return false;
            }

            System.out.println(" ....new..... ");

            for (int i = 0; i < sResult.rs.size(); i++) {
                System.out.println(sResult.rs.toArray()[i] + " rs: " + this.rs.toArray()[i]);
                if (!sResult.rs.toArray()[i].equals(this.rs.toArray()[i])) {
                    return false;
                }
            }
            System.out.println("---------");
            for (int i = 0; i < sResult.ops.size(); i++) {
                System.out.println(sResult.ops.toArray()[i] + " ops: " + this.ops.toArray()[i]);
                if (!sResult.ops.toArray()[i].equals(this.ops.toArray()[i])) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rs, ops);
        }
    }

    public static Stack<String> pass(Stack<String> s) {
        while (!s.empty()) {
            String e = s.pop();
            if (isOperator(e)) {
                if (e.contains(")")) {
                    e = s.pop();
                    while (!e.contains("(")) {

                    }
                }
            }
        }
        return null;
    }

    public static Predicate<String> operatorPredicate() {
        return ExpressionEvaluator::isOperator;
    }

    public static <T> Stack<T> parse(final String in, Predicate<String> predicate, Function<String, T> mapper) {
        if (StringUtils.isBlank(in)) {
            return new Stack<>();
        }
        char[] chars = in.toCharArray();
        String r = "";
        for (char c : chars) {
            if (isOperator(c + "")) {
                r += " " + c + " ";
            } else {
                r += c + "";
            }
        }
        final String[] els = r.trim().split(" +");
        List<T> nums = Stream.of(els).filter(predicate).map(mapper).collect(Collectors.toList());
        Stack<T> stack = new Stack<>();
        stack.addAll(nums);
        return stack;
    }

    public static boolean isOperator(String in) {
        return !(StringUtils.isAlpha(in) || StringUtils.isNumeric(in));
    }

    public static Integer simplePostfixEval(String expr) {
        String[] els = expr.split(" ");
        Stack<String> stringStack = new Stack<>();
        for (int i = els.length - 1; i >= 0; i--) {
            stringStack.push(els[i]);
        }
        return simplePostfixEval(stringStack);
    }

    public static Integer simplePostfixEval(Stack<String> elms) {
        while (elms.size() > 2) {
            if (elms.size() >= 1) {
                String v1 = elms.pop();
                String v2 = elms.pop();
                String op = elms.pop();
                if (!isOperator(op)) {
                    String wt = v1;
                    v1 = v2;
                    v2 = op;
                    op = elms.pop();
                    elms.push(wt);
                }
                int res = 0;
                if (op.contains("+")) {
                    res = Integer.parseInt(v1) + Integer.parseInt(v2);
                }
                if (op.contains("*")) {
                    res = Integer.parseInt(v1) * Integer.parseInt(v2);
                }
                elms.push(res + "");
            }
        }
        return Integer.parseInt(elms.pop());
    }
}
