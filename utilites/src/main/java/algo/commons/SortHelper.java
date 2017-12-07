/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.commons;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author mohamed
 */
public class SortHelper {

    public boolean bigIsSupToSmall(int big, int small) {
        return big >= small;
    }

    public int[] generateRandom(int from) {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        while (list.size() < from) {
            int result = r.nextInt(from);
            list.add(result);
        }
        return listToArray(list);
    }


    public int[] generateRandomAndUniq(int size) {
        int[] res = new int[size];
        int c = 0;
        Random r = new Random();
        while (c < size) {
            int randN = r.nextInt();
            for (int j = 0; j < size; j++) {
                if (res[j] == randN) {
                    continue;
                }
                randN = r.nextInt();
            }
            c++;
        }
        return res;
    }

    /**
     * very fast random unique array generator
     *
     * @param desiredSize
     * @return
     */
    public final int[] generateRandAndUniqRGL(int desiredSize) {
        int[] set = IntStream.range(0, desiredSize * 3).toArray();
        int index = set.length;
        // Fisher-Yates.
        Random rand = new Random();
        while (index > 1) {
            final int pos = rand.nextInt(index--);
            final int tmp = set[pos];
            set[pos] = set[index];
            set[index] = tmp;
        }
        return Arrays.copyOf(set, desiredSize);
    }

    /**
     * Generate an array of random & unique values in the interval [0,desiredSize*3]
     * To use only for small arrays with size in [1,50k]
     * for an array of 1k time: 0.01s
     * for an array of 10k time: 0.3s
     * for an array of 50k time: 8s
     *
     * @param desiredSize
     * @return
     */
    public int[] generateRandAndUniq(int desiredSize) {
        int[] arrayResult = new int[desiredSize];
        Random rand = new Random();
        arrayResult[0] = rand.nextInt(desiredSize);
        int counter = 0;
        while (counter < desiredSize) {
            int randValue = rand.nextInt(desiredSize * 3);/* a larger interval! */
            int[] tempArray = new int[counter + 2];
            System.arraycopy(arrayResult, 0, tempArray, 0, counter);
            tempArray[counter + 1] = randValue;
            if (!checkDuplicate(tempArray)) {
                arrayResult[counter] = randValue;
                counter++;
            }
        }
        return arrayResult;
    }

    public boolean checkDuplicate(int[] arr) {
        boolean[] bitmap = new boolean[maxValueInArray(arr) + 1];
        for (int v : arr) {
            if (!bitmap[v]) {
                bitmap[v] = true;
            } else {
                return true;
            }
        }
        return false;
    }

    public int maxValueInArray(int[] arr) {
        int max = -1;
        for (int v : arr) {
            if (v > max)
                max = v;
        }
        return max;
    }

    public void exchange(int i, int k, int[] toSort) {
        int temp = toSort[i];
        toSort[i] = toSort[k];
        toSort[k] = temp;
    }

    public int[] listToArray(List<Integer> list) {
        int j = 0;
        int[] sorted = new int[list.size()];
        for (Integer v : list) {
            if (v != null) {
                sorted[j] = v;
                j++;
            }
        }
        return sorted;
    }

    public int[] getSuppTo(int suppTo, int[] fromArr) {
        /**
         * La taille n'est pas connue en avance
         */

        int size = 0; // calculer la taille
        for (int v : fromArr) {
            if (v > suppTo) {
                size++;
            }
        }
        int[] arrOfSups = new int[size];
        int k = 0;
        for (int i = 0; i < fromArr.length; i++) {
            if (fromArr[i] > suppTo) {
                arrOfSups[k] = fromArr[i];
                k++;
            }
        }
        return arrOfSups;
    }

    public int[] getInfTo(int infTo, int[] fromArr) {
        int size = 0;
        for (int v : fromArr) {
            if (v < infTo) {
                size++;
            }
        }
        int[] arrInfsTo = new int[size];
        int k = 0;
        for (int i = 0; i < fromArr.length; i++) {
            if (fromArr[i] < infTo) {
                arrInfsTo[k] = fromArr[i];
                k++;
            }
        }
        return arrInfsTo;
    }

    public int[] getInfOrEqual(int infOrEqualTo, int[] fromArr) {
        int size = 0;
        for (int v : fromArr) {
            if (v <= infOrEqualTo) {
                size++;
            }
        }
        int[] arrInfsTo = new int[size];
        int k = 0;
        for (int i = 0; i < fromArr.length; i++) {
            if (fromArr[i] <= infOrEqualTo) {
                arrInfsTo[k] = fromArr[i];
                k++;
            }
        }
        return arrInfsTo;
    }

    public int[] getEquals(int equalsTo, int[] fromArr) {
        int size = 0;
        for (int v : fromArr) {
            if (v == equalsTo) {
                size++;
            }
        }
        int[] arrInfsTo = new int[size];
        int k = 0;
        for (int i = 0; i < fromArr.length; i++) {
            if (fromArr[i] == equalsTo) {
                arrInfsTo[k] = fromArr[i];
                k++;
            }
        }
        return arrInfsTo;
    }

    public int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + a.length];
        System.arraycopy(a, 0, res, 0, a.length);
        for (int i = 0; i < b.length; i++) {
            res[i + a.length] = b[i];
        }
        return res;
    }

    public int[] merge(int[] a, int[] b, int[] c) {
        int[] res = new int[a.length + b.length + c.length];
        System.arraycopy(a, 0, res, 0, a.length);
        for (int i = 0; i < b.length; i++) {
            res[i + a.length] = b[i];
        }
        for (int i = 0; i < c.length; i++) {
            res[i + a.length + b.length] = c[i];
        }
        return res;
    }

    /**
     * @param dup
     * @return
     */
    public int[] uniq(int[] dup) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < dup.length; i++) {
            if (!res.contains(dup[i])) {
                res.add(dup[i]);
            }
        }
        int[] arrRes = new int[res.size()];
        int k = 0;
        for (Integer v : res) {
            arrRes[k] = v;
            k++;
        }
        return arrRes;
    }

    public int[] uniq2(int[] dup) {
        Set<Integer> vs = new LinkedHashSet<>();
        for (int i = 0; i < dup.length; i++) {
            vs.add(dup[i]);
            System.out.println("Add: " + dup[i]);
        }
        int[] arrRes = new int[vs.size()];
        int k = 0;
        for (Integer v : vs) {
            arrRes[k] = v;
            System.out.println("toArr: " + v);
            k++;
        }
        return arrRes;
    }

    public boolean containDuplicat(int[] arr) {
        Set<Integer> vs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            vs.add(arr[i]);
            System.out.println("s: " + vs.size());
        }
        return vs.size() != arr.length;
    }


}
