package matrix;

import java.util.function.Function;

public class MatrixUtils {

    /**
     * Construct a matrix row from string line
     * Example:
     * in  = "1.7 5.14 9"
     * out = new Double[] { 1.7 ,5.14,9}
     *
     * @param in               string to parse
     * @param compatibleParser specialize parser
     * @param <E>              type
     * @return matrix row
     */
    public static <E> E[] parse(String in, Function<String, E> compatibleParser) {
        final String[] els = in.split(" +"); /* ignore multiple spaces */
        final E[] res = (E[]) new Object[els.length];
        int i = 0;
        for (String s : els) {
            res[i] = compatibleParser.apply(s);
            i++;
        }
        return res;
    }
}
