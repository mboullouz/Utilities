/*
 */
package sort;

import algo.commons.Sort;
import algo.commons.SortHelper;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author mohamed
 */
public class SortTest {

    SortHelper helper = new SortHelper();
    Sort sort = new Sort();
    int SIZE_OF_ARRAY = 10;
    int[] toSort = new int[SIZE_OF_ARRAY];
    int[] expecteds = new int[SIZE_OF_ARRAY];

    public SortTest() {
    }

    //	@Before
//	public void setUp() throws Exception {
//		toSort = helper.generateRandom(SIZE_OF_ARRAY);
//		int[] cp = new int[SIZE_OF_ARRAY];
//		System.arraycopy(toSort, 0, cp, 0, SIZE_OF_ARRAY);
//		expecteds = sort.bubbleSort(cp);
//	}
//	
//	@Test
//	public void testGenerateRandomUniq(){
//		int max=1000;
//		int[] rand = helper.generateRandAndUniq(max);
//		assertTrue(max==rand.length);
//	}
    @Test
    public void testgenerateRandAndUniqRGL() {
        int max = 1000000;
        int[] rand = helper.generateRandAndUniqRGL(max);
        assertTrue(max == rand.length);
    }

//
//	@Test
//	public void testUniq() {
//		int[] dup = { 3, 2, 2, 3, 1, 5, 0, 0, 0, 0 };
//		int[] expected = { 3, 2, 1, 5, 0 };
//		assertArrayEquals(expected, helper.uniq(dup));
//		assertArrayEquals(expected, helper.uniq2(dup));
//	}
//
//	@Test
//	public void testIsUniq() {
//		int[] dup = { 3, 2, 2, 3, 1, 5, 0, 0, 0, 0 };
//		int[] expected = { 3, 2, 1, 5, 0 };
//		assertTrue(helper.containDuplicat(dup));
//		assertFalse(helper.containDuplicat(expected));
//		/** ... Faster using two arrays ... */
//		assertTrue(helper.checkDuplicate(dup));
//		assertFalse(helper.checkDuplicate(expected));
//	}
//
//	@Test
//	public void testMergeTwoArrays() {
//		int[] a = { 1, 2, 3 };
//		int[] b = { 4, 5, 6 };
//		int[] ex = { 1, 2, 3, 4, 5, 6 };
//		assertArrayEquals(ex, helper.merge(a, b));
//	}
//
//	@Test
//	public void testMergeThreeArrays() {
//		int[] a = { 1, 2, 3 };
//		int[] b = { 4, 5, 6 };
//		int[] c = { 7, 8, 9 };
//		int[] ex = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		assertArrayEquals(ex, helper.merge(a, b, c));
//	}
//
//	@Test
//	public void testBubbleSort() {
//		assertArrayEquals(expecteds, sort.bubbleSort(toSort));
//	}
//
//	@Test
//	public void testQuickSort() {
//		assertArrayEquals(expecteds, sort.quickSort(toSort));
//	}
//
//	@Test
//	public void testMergeSort() {
//		assertArrayEquals(expecteds, sort.mergeSort(toSort));
//	}
//
//	@Test
//	public void testRunningTimeForMergeSortInfNLogN() {
//		int n = expecteds.length;
//		int nLogN = (int) (n * Math.log(n));
//		sort.mergeSort(toSort);
//		assertTrue(helper.bigIsSupToSmall(nLogN, sort.getRunningtime()));
//	}
//
//	@Test
//	public void TestGenerateRandomHaveSameSize() {
//		assertEquals(10, helper.generateRandom(10).length);
//	}
}
