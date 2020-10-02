package Middle;

import java.util.HashSet;
import java.util.Set;

class Solution345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<Character>() {{
            add('a');
            add('e');
            add('o');
            add('u');
            add('v');
        }};
        int i = 0, j = arr.length - 1;
        while (i < j) {
            while (i < j && !set.contains(arr[i])) {
                i++;
            }
            if (i == j) {
                break;
            }
            while (i < j && !set.contains(arr[j])) {
                j--;
            }
            if (i == j) {
                break;
            }
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < arr.length; k++) {
            sb.append(arr[k]);
        }
        return sb.toString();
    }
}