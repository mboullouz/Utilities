package algo.commons;

public class FindAlg {
	static int counter = 0;

	public static void main(String[] args) {
		  int[] arr = { 1,2, 3,3, 7, 11, 18, 20, 32, 41,
		  50,78,91,102,152,207,250,309,311,311,400};
		int toFind = 41;

		System.out.println("Should Found: " + toFind + " ...: " + find(arr, toFind) + " | Counter: " + counter);
		System.out.println("Found: 71  ...: " + find(arr, 71) + " | counter: " + counter);
		System.out.println("Found: -11  ...: " + find(arr, -11) + " | Counter: " + counter);
		System.out.println("Should Found: 1  ...: " + find(arr, 1) + " | Counter: " + counter);
		System.out.println("Should Found: 50  ...: " + find(arr, 50) + " | Counter: " + counter);
		System.out.println("Should Found: 3  ...: " + find(arr, 3) + " | Counter: " + counter);
		System.out.println("Should Found: 18 ...: " + find(arr, 18) + " | Counter: " + counter);
		System.out.println("Should Found: 41 ...: " + find(arr, 41) + " | Counter: " + counter);
		System.out.println("Should Found: 400 ...: " + find(arr, 400) + " | Counter: " + counter);
		System.out.println("Should Found: 3 ...: " + find(arr, 3) + " | Counter: " + counter);
		System.out.println("Should Found: 2 ...: " + find(arr, 2) + " | Counter: " + counter);
		System.out.println("Found: 950 ...: " + find(arr, 950) + " | Counter: " + counter);
	}

	/**
	 * Search in an already sorted array duplicate values are handled
	 * 
	 * @param arrayToScan
	 * @param valueToFind
	 * @return
	 */
	public static boolean find(int[] arrayToScan, int valueToFind) {
		if (arrayToScan.length == 0) {
			return false;
		}
		counter = 0;
		int startIndex = 0, endIndex = arrayToScan.length, midleIndex;
		while (true) {
			counter++;
			midleIndex = (startIndex + endIndex) / 2;
			if (arrayToScan[midleIndex] == valueToFind) {
				return true;
			}
			if (startIndex >= endIndex || midleIndex == 0 || midleIndex == arrayToScan.length - 1) {
				return false;
			}
			if (valueToFind > arrayToScan[midleIndex]) {
				startIndex = midleIndex + 1;
			}
			if (valueToFind < arrayToScan[midleIndex]) {
				endIndex = midleIndex - 1;
			}

		}
	}

}
