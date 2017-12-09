package common;

public class SimpleArrayAlgo {
    /**
     * Remove an element of an array of ints by resizing and coping to new array!
     *
     * @param from     array
     * @param toRemove to remove
     * @return new array without the element
     */
    public static int[] remove(int[] from, int toRemove) {
        if (from == null) {
            return new int[]{};
        }
        int index = -1;
        for (int i = 0; i < from.length; i++) {
            if (toRemove == from[i]) {
                index = i;
            }
        }
        System.out.println("index of element to remove " + index);
        if (index >= 0) {
            int[] cp = new int[from.length - 1];
            for (int k = 0, z = 0; k < cp.length; k++, z++) {
                if (z == index) {
                    z++;
                }
                cp[k] = from[z];
            }
            return cp;
        } else {
            return from;
        }
    }
}
