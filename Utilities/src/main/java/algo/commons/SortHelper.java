/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.commons;

/**
 *
 * @author mohamed
 */
public class SortHelper {
    
    public void exchange(int i, int k, int[] toSort) {
        int temp = toSort[i];
        toSort[i] = toSort[k];
        toSort[k] = temp;
    }

    public int[] getSuppTo(int suppTo, int[] fromArr) {
        /**
         * La taille n'est pas connue en avance
         */
        int size = 0; //calculer la taille
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
    
}
