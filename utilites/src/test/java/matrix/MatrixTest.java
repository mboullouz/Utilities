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
    public void genericMultiLinesToMatrix() {
        String line0 = "1 2 3";
        String line1 = "1 2 3";
        Double[][] exp = new Double[][]{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};
        Double[][] res = (Double[][]) MatrixUtils.linesToRow(new String[]{line0, line1}, Double::valueOf);
        Assert.assertArrayEquals(exp, res);
    }

    @Test
    public void multiLinesToMatrix() {
        String line0 = "1 2 3";
        String line1 = "1 2 3";
        Double[][] exp = new Double[][]{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};
        Double[][] res = MatrixUtils.lineToRow(new String[]{line0, line1});
        Assert.assertArrayEquals(exp, res);

    }


}
