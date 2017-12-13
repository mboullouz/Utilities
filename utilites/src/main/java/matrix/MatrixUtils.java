package matrix;

import java.util.function.Function;
import java.util.stream.Stream;

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

    /**
     * TODO find a way to use something like E[][]
     */
    public static Double[][] lineToRow(String[] ins, int cols) {
        int i = 0;
        Double[][] res = new Double[ins.length][cols];
        for (String ss : ins) {
            int j = 0;
            final String[] els = ss.split(" +");
            if (els.length > cols) {
                throw new ArithmeticException("String lines should be consistant with cols! found cols in sting: " + els.length + " but provided cols: " + cols);
            }
            for (String s : els) {
                res[i][j] = Double.valueOf(s);
                j++;
            }
            i++;
        }
        return res;
    }

    public static String plotMartix(Double[][] matrix) {
        final StringBuilder sb = new StringBuilder();
        Stream.of(matrix).forEach(v -> {
                    sb.append("| ");
                    Stream.of(v).forEach(k -> sb.append(k).append(" "));
                    sb.append("|\n");
                }
        );
        return sb.toString();
    }

    public static Double[] diagonal(Double[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new Double[]{};
        }
        Double[] diagList = new Double[matrix.length];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            diagList[k] = (matrix[i][i]);
            k++;
        }
        return diagList;
    }

    public static Double[] opposedDiagonal(Double[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new Double[]{};
        }
        Double[] diagList = new Double[matrix.length];
        int k = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            diagList[k] = (matrix[matrix.length - 1 - i][i]);
            k++;
        }
        return diagList;
    }

    public static Double det(Double[][] matrix) {
        return null;
    }

    public static Double[][] optimizeForZeros(Double[][] matrix) {
        return null;
    }

    public static Double[][] lineMultiuplyByX(Double[][] matrix, int row, int multiply) {
        return null;
    }

    public static Double[][] colMultiuplyByX(Double[][] matrix, int col, int multiply) {
        return null;
    }


}
