package struct.map;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class MHashMap<K, E> {

    public static int initSize = 10 * 1000;
    public static int countResize = 0;
    private static int sz = 0;
    Object[] table = new Object[initSize];

    public void put(K key, E obj) {
        int index = hashFunc(key);
        if (sz > initSize * 0.85) {
            resize();
        }
        int ix = Math.abs(index % initSize);
        if (table[ix] != null) {
            System.out.println("collision, ix: " + ix + " v: " + obj + " will replace: " + table[ix]);
        }
        sz++;
        table[ix] = obj;
    }

    private void resize() {
        sz = initSize;
        initSize *= 2;
        Object[] newTable = new Object[initSize];
        for (int i = 0; i < sz; i++) {
            newTable[i] = table[i];
        }
        table = newTable;
        countResize++;
        System.out.println("Resize success ..copying finished");
    }

    public Object[] getTable() {
        return table;
    }

    public void printAll() {
        for (Object o : table) {
            if (o != null) {
                System.out.println(o);
            }
        }
    }

    public Object get(K key) {
        int index = hashFunc(key);
        int ix = Math.abs(index % initSize);
        return table[ix];
    }

    public int size() {
        int s = 0;
        for (Object o : table) {
            if (o != null) {
                s++;
            }
        }
        return s;
    }

    private int hashFunc(K key) {
        int i = 0;
        i = HashCodeBuilder.reflectionHashCode(key);
        System.out.println("\n for key: " + key + " code:" + i);
        return i;
    }

}