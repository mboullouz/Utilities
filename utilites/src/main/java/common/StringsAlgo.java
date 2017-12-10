package common;

public class StringsAlgo {
    /**
     * Compare 2 string based on alphabetic order independent of Strings length, ex
     * str1= "abc", str2= "bcdef"
     * return => -1 (as "a" < "b")
     * NB: Applying this method to sort array:
     * 1) in ["x", "", null, "aba"] out [null, "", "aba", "x"];
     * 2) in ["", null] out [null, ""]
     *
     * @param str1 first string
     * @param str2 second string
     * @return compare result
     */
    public static int alphabeticOrder(String str1, String str2) {
        if (str1 == null || str1.equals("")) {
            return -1;
        }
        if (str2 == null || str2.equals("")) {
            return 1;
        }
        if (str1.equals(str2)) {
            return 0;
        }

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
