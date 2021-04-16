package Middle;

public class Solution424 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int maxn = 0;
        int[] count = new int[26];
        int right = 0, left = 0;
        while (right < len) {
            char c = s.charAt(right);
            count[c - 'A']++;
            maxn = Math.max(maxn, count[c - 'A']);
            if (right - left + 1 - maxn > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        new Solution424().characterReplacement("BAAA", 0);
    }
}
