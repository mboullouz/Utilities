package common;

public class StringsAlgo {
	public static int compare(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		int l1 = ch1.length;
		int l2 = ch2.length;

		int small = l1 >= l2 ? l2 : l1;
		for (int i = 0; i < small; i++) {
			if (ch1[i] < ch2[i]) {
				return -1;
			}
			if (ch1[i] > ch2[i]) {
				return 1;
			}
		}
		return 0;
	}
}
