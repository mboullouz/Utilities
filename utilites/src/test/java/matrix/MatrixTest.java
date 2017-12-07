package matrix;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

    @Test
    public void stringLineToMatrixRow() {
        String line0 = "1 2 3";
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, MatrixUtils.parse(line0, Integer::parseInt));
        Assert.assertArrayEquals(new Double[]{1.7, 2.99, 3.8}, MatrixUtils.parse("1.7   2.99 3.8", Double::valueOf));

        Assert.assertArrayEquals(
                new SimpleInt[]{new SimpleInt(10), new SimpleInt(99)},
                MatrixUtils.parse(
                        "10 99",
                        k -> new SimpleInt(Integer.parseInt(k))
                ));
    }
}
