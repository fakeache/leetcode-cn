package Middle;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rs = new ArrayList<>();
        int plen = p.length();
        if (s == null || s.length() < plen) {
            return rs;
        }
        int[] arrs = new int[26];
        int[] arrp = new int[26];
        for (int i = 0; i < plen; i++) {
            arrp[p.charAt(i) - 'a']++;
        }
        int left = 0, end = plen - 1, slen = s.length();
        for (int right = 0; right < slen; right++) {
            char c = s.charAt(right);
            arrs[c - 'a']++;
            while (arrs[c - 'a'] > arrp[c - 'a']) {
                arrs[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == plen) {
                rs.add(left);
            }
        }
        return rs;
    }
}
