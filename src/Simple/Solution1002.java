package Simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1002 {
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] min = new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (String s : A) {
            int len = s.length();
            int[] arr = new int[26];
            for (int i = 0; i < len; i++) {
                arr[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                min[i] = Math.min(min[i], arr[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < min[i]; j++) {
                list.add(String.valueOf((char)('a' + i)));
            }
        }
        return list;
    }
}
