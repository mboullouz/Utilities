/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import algo.commons.Sort;
import algo.commons.SortHelper;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mohamed
 */
public class SortTest {

    SortHelper helper = new SortHelper();
    Sort sort = new Sort();
    int sizeOfArrayToSort = 10;
    int[] toSort = new int[sizeOfArrayToSort];
    int[] expecteds=new int[sizeOfArrayToSort];

    public SortTest() {
         
    }
     
    @Before
    public void setUp() throws Exception {
        toSort= helper.generateRandom(sizeOfArrayToSort);
        int[] cp =   new int[sizeOfArrayToSort];
        System.arraycopy(toSort, 0, cp,0, sizeOfArrayToSort);
        expecteds = sort.bubbleSort(cp);
    }

    @Test
    public void testMergeTwoArrays() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        int[] ex = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(ex, helper.merge(a, b));
    }

    @Test
    public void testMergeThreeArrays() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        int[] c = {7, 8, 9};
        int[] ex = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(ex, helper.merge(a, b, c));
    }

    @Test
    public void testBubbleSort() {
        assertArrayEquals(expecteds, sort.bubbleSort(toSort));
    }

    @Test
    public void testQuickSort() {
        assertArrayEquals(expecteds, sort.quickSort(toSort));

    }

    @Test
    public void testMergeSort() {
        assertArrayEquals(expecteds, sort.mergeSort(toSort));
    }
 

    //@Test
    public void testRunningTimeForMergeSortInfNLogN() {
        int n = expecteds.length;
        int nLogN = (int) (n * Math.log(n));
        sort.mergeSort(toSort);
        assertTrue(helper.bigIsSupToSmall(nLogN, sort.getRunningtime()));

    }
    @Test
    public void TestGenerateRandomHaveSameSize() {
        assertEquals(10, helper.generateRandom(10).length);
    }

}
