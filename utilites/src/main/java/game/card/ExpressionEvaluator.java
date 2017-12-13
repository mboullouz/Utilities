package game.card;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
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

    public static Integer doMath(Stack<Integer> numbers, Stack<String> operators) {
        Integer result = 0;
        Integer left = 0;
        Integer right = 0;
        while (!numbers.empty()) {
            left = numbers.pop();
            if (numbers.empty())
                right = 0;
            else
                right = numbers.pop();
            result += left + right;
            if (!operators.empty())
                operators.pop();
        }
        return result;
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
        System.out.println(r);
        final String[] els = r.trim().split(" +");
        List<T> nums = Stream.of(els).filter(predicate).map(mapper).collect(Collectors.toList());
        Stack<T> stack = new Stack<>();
        stack.addAll(nums);
        return stack;
    }

    public static boolean isOperator(String in) {
        return !(StringUtils.isAlpha(in) || StringUtils.isNumeric(in));
    }
}
