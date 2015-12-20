/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct.list;

/**
 *
 * @author mohamed
 */
public class MyList {

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

}
