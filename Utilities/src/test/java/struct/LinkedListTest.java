/*
 */
package struct;

import struct.list.OperationHelper;
import struct.list.MyList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mohamed
 */
public class LinkedListTest {

    MyList head;
    OperationHelper operationHelper = new OperationHelper();

    @Test
    public void testListeNonVide() {
        assertEquals(true, operationHelper.sizeOfList(head) >= 1);
    }
    @Test
    public void testTraverseListe() {
        int[] expected = {3, 7, 4, 11, 9};
        int[] listeData = operationHelper.linkedListDataToArray(head);
        assertArrayEquals(expected, listeData);
    }

    @Test
    public void testInsertInFrontOfLinkedList() {
        int[] expecteds = {8, 3, 7, 4, 11, 9};
        MyList newHead = new MyList(8);
        operationHelper.insertInFront(head, newHead);
        int[] result = operationHelper.linkedListDataToArray(newHead);
        assertArrayEquals(expecteds, result);
    }

    @Test
    public void testDeleteHead() {
        int[] expecteds = {7, 4, 11, 9};
        MyList cpHead;
        cpHead = head.getNext();
        head = null;
        head = cpHead;
        int[] result = operationHelper.linkedListDataToArray(head);
        assertArrayEquals(expecteds, result);
    }

    @Test
    public void testNthElementToFromEnd() {
        //int[] expected = {3, 7, 4, 11, 9};
        int expectedValue = 4;
        int nthFromEnd=3;         
        assertEquals(expectedValue, operationHelper.getNthFromTheEnd(head, nthFromEnd).getData());
        assertEquals(7, operationHelper.getNthFromTheEnd(head, 4).getData());
    }
    @Test
    public void testInvertList(){
        int[] expected={9,11,4,7,3};
        assertArrayEquals(expected, operationHelper.linkedListDataToArray(operationHelper.invertList(head)));
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        head = new MyList(3);
        head.setNext(new MyList(7));
        MyList n1 = head.getNext();
        n1.setNext(new MyList(4));
        MyList n2 = n1.getNext();
        n2.setNext(new MyList(11));
        MyList n3 = n2.getNext();
        n3.setNext(new MyList(9));
    }

    @After
    public void tearDown() {
    }

}
