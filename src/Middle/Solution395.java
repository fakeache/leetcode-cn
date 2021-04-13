package Middle;

public class Solution395 {
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int start, int end, int k) {
        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            count[s.charAt(i) - 'a']++;
        }
        int idx = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return end - start + 1;
        }
        int l = start;
        int rs = 0;
        while (l <= end) {
            while (l <= end && s.charAt(l) - 'a' == idx) {
                l++;
            }
            if (l > end) {
                break;
            }
            int r = l;
            while (r <= end && s.charAt(r) - 'a' != idx) {
                r++;
            }
            rs = Math.max(rs, dfs(s, l, r - 1, k));
            l = r;
        }
        return rs;
    }
}
