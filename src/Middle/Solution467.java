package Middle;

public class Solution467 {
    int N = 26;
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        int[] dp = new int[N];
        char[] parr = p.toCharArray();
        int count = 0;
        for (int i = 0; i < parr.length; i++) {
            count++;
            int c = parr[i] - 'a';
            dp[c] = Math.max(dp[c], count);
            if (i == parr.length - 1 || (parr[i + 1] - parr[i] + N) % N != 1) {
                count = 0;
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
