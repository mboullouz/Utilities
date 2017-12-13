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
        if (StringUtils.isBlank(in)) {
            return new Stack<>();
        }
        final String[] els = in.split(" +");
        List<Integer> nums = Stream.of(els).filter(StringUtils::isNumeric).map(Integer::valueOf).collect(Collectors.toList());
        Stack<Integer> stack = new Stack<>();
        stack.addAll(nums);
        return stack;
    }

    public static Stack<String> operators(final String in, Predicate<String> predicate) {
        if (StringUtils.isBlank(in)) {
            return new Stack<>();
        }
        Stack<String> stack = new Stack<>();
        stack.addAll(Stream.of(in.split(" +")).filter(predicate).collect(Collectors.toList()));
        return stack;
    }

    public static Predicate<String> operatorPredicate() {
        return s -> !(StringUtils.isAlpha(s) || StringUtils.isNumeric(s));
    }

    public static <T> Stack<T> parse(final String in, Predicate<String> predicate, Function<String,T> mapper) {
        if (StringUtils.isBlank(in)) {
            return new Stack<>();
        }
        final String[] els = in.split(" +");
        List<T> nums = Stream.of(els).filter(predicate).map(mapper).collect(Collectors.toList());
        Stack<T> stack = new Stack<>();
        stack.addAll(nums);
        return stack;
    }
}
