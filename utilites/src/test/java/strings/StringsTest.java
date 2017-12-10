package strings;

import common.StringsAlgo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringsTest {
    @Test
    public void alphaOrderOfStrings() {
        List<String> list = Arrays.asList("Lyon", "paris", "grenoble", "nantes", "lille");
        String s = list.stream()
                .map(String::toUpperCase)
                .sorted(StringsAlgo::alphabeticOrder)
                .filter(v -> v.length() > 2)
                .max((x, y) -> x.length() > y.length() ? x.length() : y.length())
                .get();
        Assert.assertEquals("GRENOBLE", s);

        List<String> l2 = Arrays.asList("abc", "aba");
        String s2 = l2.stream()
                .sorted(StringsAlgo::alphabeticOrder)
                .findFirst().get();
        Assert.assertEquals("aba", s2);

        Assert.assertEquals(-1, StringsAlgo.alphabeticOrder("abc", "bcdef"));

        Assert.assertEquals(-1, StringsAlgo.alphabeticOrder(null, "bcdef"));


        List<String> l3Exp = Arrays.asList(null, "", "aba", "x");
        List<String> orderRes3 = Stream.of("x", "", null, "aba")
                .sorted(StringsAlgo::alphabeticOrder)
                .collect(Collectors.toList());
        Assert.assertEquals(l3Exp, orderRes3);

        Assert.assertEquals(
                Arrays.asList(null, ""),
                Stream.of("", null)
                        .sorted(StringsAlgo::alphabeticOrder)
                        .collect(Collectors.toList())
        );

    }
}
