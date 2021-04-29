package Hard;

public class Solution76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        int slen = s.length(), tlen = t.length();
        int[] tnum = new int[128];
        char[] tarr = t.toCharArray(), sarr = s.toCharArray();
        for (int i = 0; i < tlen; i++) {
            tnum[tarr[i]]++;
        }
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = 0;
        int count = tlen;
        while (right < slen) {
            char c = sarr[right];
            if (tnum[c] > 0) {
                count--;
            }
            tnum[c]--;
            if (count == 0) {
                while (left <= right && tnum[sarr[left]] < 0) {
                    tnum[sarr[left]]++;
                    left++;
                }
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                tnum[sarr[left]]++;
                left++;
                count++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
