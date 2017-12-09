package matrix;

import java.util.function.Function;

public class MatrixUtils {

    /**
     * Construct a matrix row from string line
     * Example:
     * in  = "1.7 5.14 9"
     * out = new Double[] { 1.7 ,5.14,9}
     *
     * @param in               string to lineToRow
     * @param compatibleParser specialize parser
     * @param <E>              type
     * @return matrix row
     */
    public static <E> E[] lineToRow(String in, Function<String, E> compatibleParser) {
        final String[] els = in.split(" +"); /* ignore multiple spaces */
        final E[] res = (E[]) new Object[els.length];
        int i = 0;
        for (String s : els) {
            res[i] = compatibleParser.apply(s);
            i++;
        }
        return res;
    }

    public static Object linesToRow(String[] in, Function<String, Object> compatibleParser) {
        final Object[][] res = new Object[in.length][3];
        int i = 0;
        for (String s : in) {
            res[i] = lineToRow(s,compatibleParser);
            i++;
        }
        return res;
    }



    /**
     * TODO find a way to use something like E[][]
     */
    public static Double[][] lineToRow(String[] ins) {
        int i = 0;
        Double[][] res = new Double[ins.length][3];
        for (String ss : ins) {
            int j = 0;
            final String[] els = ss.split(" +");
            for (String s : els) {
                res[i][j] = Double.valueOf(s);
                j++;
            }
            i++;
        }
        return res;
    }



}
