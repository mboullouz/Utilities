package struct.list;

import java.util.Set;
import java.util.TreeSet;

public class ListMain {

    public static void main(String[] args) {
        MyList l1 = new MyList(1);
        MyList l2 = new MyList(14);
        MyList l3 = new MyList(7);
        MyList l4 = new MyList(3);

        Set<MyList> sorted = new TreeSet<>();
        sorted.add(l1);
        sorted.add(l2);
        sorted.add(l3);
        sorted.add(l4);
        sorted.forEach(e -> {
            System.out.println(e.data + " ");
        });
    }

}
