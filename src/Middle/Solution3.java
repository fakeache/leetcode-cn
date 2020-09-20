package Middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int sLen = s.length();
        int lk = -1, rk = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sLen; i++) {
            rk++;
            char rv = s.charAt(rk);
            if (!set.contains(rv)) {
                set.add(rv);
            } else {
                lk++;
                max = Math.max(rk - lk, max);
                while (s.charAt(lk) != rv) {
                    set.remove(s.charAt(lk));
                    lk++;
                }
            }
        }
        return max;
    }

    /**
     * 滑动窗口 简单解法
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sLen = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = -1;
        int max = 0;
        for (int i = 0; i < sLen; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        s.lengthOfLongestSubstring("abcabcbb");
    }
}
