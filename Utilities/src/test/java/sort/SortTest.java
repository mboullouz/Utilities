/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import algo.commons.Sort;
import algo.commons.SortHelper;
import org.hamcrest.core.Is;
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
    int sizeOfArrayToSort = 100;
    int[] toSort;
    int[] expecteds;

    public SortTest() {
        expecteds = getExpectedArray();
    }

    private int[] getExpectedArray() {
        int[] newArr = new int[sizeOfArrayToSort];
        for (int i = 0; i < sizeOfArrayToSort; i++) {
            newArr[i] = i;
        }
        return newArr;
    }

    @Before
    public void setUp() throws Exception {
        toSort= helper.generateRandom(sizeOfArrayToSort);
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

    @Test
    public void testMergeSortStack() {
        assertArrayEquals(expecteds, sort.mergeSortStack(toSort));
    }

    @Test
    public void testRunningTimeForMergeSortInfNLogN() {
        int n = expecteds.length;
        int nLogN = (int) (n * Math.log(n));
        sort.mergeSort(toSort);
        assertTrue(helper.bigIsSupToSmall(nLogN, sort.getRunningtime()));

    }

    @Test
    public void testRunningTimeForSortByStackIsInfTo2N() {
        int n = 2 * expecteds.length + 5;
        sort.mergeSortStack(toSort);
        assertTrue(helper.bigIsSupToSmall(n, sort.getRunningtime()));

    }

    @Test
    public void TestGenerateRandomHaveSameSize() {
        assertEquals(200, helper.generateRandom(200).length);
    }

}
