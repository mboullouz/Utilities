/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct.list;

/**
 * @author mohamed
 */
public class MyList implements Comparable<MyList> {

    int data;
    MyList next;

    public MyList(int i) {
        this.data = i;
    }

    public MyList getNext() {
        return this.next;
    }

    public void setNext(MyList myList) {
        this.next = myList;
    }

    public int getData() {
        return this.data;
    }

    @Override
    public int compareTo(MyList other) {
        if (other.getData() > this.data) {
            return -1;
        }
        if (this.data > other.getData()) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Used eqls");
        return compareTo((MyList) obj) == 0;
    }


}
