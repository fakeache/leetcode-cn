package Middle;

import java.util.*;

class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }
        int L = 10, len = s.length();
        int[] num = new int[len];
        Set<Integer> setInt = new HashSet<>();
        Set<String> setString = new HashSet<>();
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};
        for (int i = 0; i < len; i++) {
            num[i] = map.get(s.charAt(i));
        }
        int son = 0;
        for (int i = 0; i < len - L + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < L; j++) {
                    son = son << 2;
                    son |= num[j];
                }
            } else {
                son = son << 2;
                son |= num[i + L - 1];
                son &= ~(3 << 2 * L);
            }
            if (setInt.contains(son)) {
                setString.add(s.substring(i, i + L));
            } else {
                setInt.add(son);
            }
        }
        return new ArrayList<>(setString);
    }
}
