package j8.func;

import common.StringsAlgo;

import java.util.Arrays;
import java.util.List;

public class FuncMain {

    public static void main(String[] args) {
        System.out.println("Starts...");
        List<String> list = Arrays.asList("Lyon", "paris", "grenoble", "nantes", "lille");
        list.stream()
                .map(String::toUpperCase)
                .sorted(StringsAlgo::compare)
                .filter(v -> v.length() > 2)
                .max((x, y) -> x.length() > y.length() ? x.length() : y.length())
                .ifPresent(System.out::println);
    }

}
