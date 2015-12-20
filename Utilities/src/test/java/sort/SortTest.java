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

    public SortTest() {
    }

    int[] expecteds = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    int[] toSort = {14, 15, 4, 2, 1, 3, 11, 13, 10, 12, 7, 6, 8, 5, 9};
    Sort sort = new Sort();
    SortHelper helper = new SortHelper();

    @Before
    public void setUp() throws Exception {
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
}
