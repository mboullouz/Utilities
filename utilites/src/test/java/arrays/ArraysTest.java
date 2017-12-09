package arrays;

import common.SimpleArrayAlgo;
import org.junit.Assert;
import org.junit.Test;


public class ArraysTest {
    @Test
    public void removeElementFromIntArrayTest() {

        //last element
        Assert.assertArrayEquals(new int[]{1, 2}, SimpleArrayAlgo.remove(new int[]{1, 2, 3}, 3));
        //non existing element!
        Assert.assertArrayEquals(new int[]{1, 2}, SimpleArrayAlgo.remove(new int[]{1, 2}, 7));

        //empty
        Assert.assertArrayEquals(new int[]{}, SimpleArrayAlgo.remove(new int[]{}, 7));

        //null element
        Assert.assertArrayEquals(new int[]{}, SimpleArrayAlgo.remove(null, 7));

        //first element!
        int[] arr0 = {1, 7, 2, 5, 2, 4, 9, 11};
        int[] exp0 = {7, 2, 5, 2, 4, 9, 11};
        Assert.assertArrayEquals(exp0, SimpleArrayAlgo.remove(arr0, 1));


    }
}
