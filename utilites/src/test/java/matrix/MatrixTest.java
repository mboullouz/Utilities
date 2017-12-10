package matrix;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

    @Test
    public void stringLineToMatrixRow() {

        String line0 = "1 2 3";
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, MatrixUtils.lineToRow(line0, Integer::parseInt));
        Assert.assertArrayEquals(new Double[]{1.7, 2.99, 3.8}, MatrixUtils.lineToRow("1.7   2.99 3.8", Double::valueOf));

        Assert.assertArrayEquals(
                new SimpleInt[]{new SimpleInt(10), new SimpleInt(99)},
                MatrixUtils.lineToRow(
                        "10 99",
                        k -> new SimpleInt(Integer.parseInt(k))
                ));
    }

    @Test
    public void multiLinesToMatrix() {
        String line0 = "1 2 3";
        String line1 = "1 2 3";
        Double[][] exp = new Double[][]{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};
        Double[][] res = MatrixUtils.lineToRow(new String[]{line0, line1}, 3);
        Assert.assertArrayEquals(exp, res);
    }

    @Test
    public void plotMatrix() {
        String line0 = "1 2 3";
        String line1 = "4 5 6";
        Double[][] res = MatrixUtils.lineToRow(new String[]{line0, line1, line0}, 3);
        String plot = MatrixUtils.plotMartix(res);
        String exp = "" +
                "| 1.0 2.0 3.0 |\n" +
                "| 4.0 5.0 6.0 |\n" +
                "| 1.0 2.0 3.0 |\n";
        Assert.assertEquals(
                exp.replaceAll("(?m)^[ \t]*\r?\n", "").replaceAll(" ", ""),
                plot.replaceAll("(?m)^[ \t]*\r?\n", "").replaceAll(" ", "")
        );
    }

    @Test
    public void diagonalOfAMatrix() {
        String line0 = "1 2";
        String line1 = "5 6";
        Double[] exp = new Double[]{1.0, 6.0};
        Double[][] matrix = MatrixUtils.lineToRow(new String[]{line0, line1}, 2);
        Assert.assertArrayEquals(exp, MatrixUtils.diagonal(matrix));

        String lineA = "1 2 3";
        String lineB = "5 6 7";
        String lineC = "8 9 10";
        Double[] exp2 = new Double[]{1.0, 6.0, 10.0};
        Double[][] matrix2 = MatrixUtils.lineToRow(new String[]{lineA, lineB, lineC}, 3);
        Assert.assertArrayEquals(exp2, MatrixUtils.diagonal(matrix2));
    }

    @Test
    public void oposedDiagonalOfMatrix() {
        String lineA = "1 2 3";
        String lineB = "5 6 7";
        String lineC = "8 9 10";
        Double[] exp2 = new Double[]{3.0, 6.0, 8.0};
        Double[][] matrix2 = MatrixUtils.lineToRow(new String[]{lineA, lineB, lineC}, 3);
        Assert.assertArrayEquals(exp2, MatrixUtils.opposedDiagonal(matrix2));
    }

}
