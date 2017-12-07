/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct.list;

/**
 * @author mohamed
 */
public class OperationHelper {

    public int[] linkedListDataToArray(MyList head) {
        int[] listeData = new int[sizeOfList(head)];
        int i = 0;
        while (head != null) {
            listeData[i] = head.getData();
            head = head.getNext();
            i++;
        }
        return listeData;
    }

    public int[] linkedListDataToArrayFixedSize(MyList head, int size) {
        int[] listeData = new int[size];
        int i = 0;
        while (head != null) {
            listeData[i] = head.getData();
            head = head.getNext();
            i++;
        }
        return listeData;
    }

    public MyList getNthFromTheEnd(MyList head, int nthFromEnd) {
        int counterFromBeginingToNth = 0;
        while (head != null && sizeOfList(head) - counterFromBeginingToNth >= nthFromEnd) {
            counterFromBeginingToNth++;
            head = head.getNext();
        }
        return head;
    }

    public void insertInFront(MyList head, MyList element) {
        element.setNext(head);
        head = element;
    }

    public MyList invertList(MyList head) {
        MyList current = head;
        MyList previous = null;

        while (head != null) {
            head = head.getNext();
            current.setNext(previous);
            previous = current;
            current = head;
        }
        return previous;
    }

    public int sizeOfList(MyList head) {
        int i = 0;
        while (head != null) {
            head = head.getNext();
            i++;
        }
        return i;
    }

}
