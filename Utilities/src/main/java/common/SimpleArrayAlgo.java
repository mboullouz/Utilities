package common;

import java.util.stream.IntStream;

public class SimpleArrayAlgo {

	public static void main(String[] args) {
		int[] arr = { 1, 7, 2, 5, 2, 4, 9, 11 };

		IntStream.of(delete(arr, 1)).forEach(v -> {
			System.out.print(", " + v);
		});

	}

	public static int[] delete(int[] from, int elm) {
		int index = -1;
		for (int i = 0; i < from.length; i++) {
			if (elm == from[i]) {
				index = i;
			}
		}
		System.out.println("index " + index);
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
