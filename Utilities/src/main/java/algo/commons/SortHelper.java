/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.commons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
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

	public int[] generateRandAndUniq(int size) {
		int[] res = new int[size];
		Random rand = new Random();
		res[0]= rand.nextInt(size);
		int k = 0;
		int max= size*5;
		while (k < size && max>0) {
			int r = rand.nextInt(size*5);
			int[] resTemp= new int[k+2];
			System.arraycopy(res, 0, resTemp,0, k);
			resTemp[k+1]=r;
			if(fasterContainDuplicat(resTemp)){
				max--; //protect against overflow!
			}
			else {
				res[k]=r;
				k++;
			}
		}
		 
		System.out.println("Attention! rand already consumed: "+(size*5-max));
		 

		return res;
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

	public boolean fasterContainDuplicat(int[] arr) {
		/**
		 *  We could just put the max value: like Math.pow(2,30)
		 *  But its better to 
		 */
		boolean[] bitmap = new boolean[maxValueInArray(arr)+2]; 
		for (int v : arr) {
			if (!bitmap[v]) {
				bitmap[v] = true;
			} else {
				return true;
			}
		}

		return false;
	}
	
	public int maxValueInArray(int[] arr){
		int max=-1;
		for(int v:arr){
			if(v>max)
				max=v;
		}
		return max;
	}

}
