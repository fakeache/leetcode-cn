package Hard;

public class Solution87 {
    int[][][] memo;
    String s1, s2;
    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        int len = s1.length();
        this.memo = new int[len][len][len + 1];
        return dfs(0, 0, len);
    }

    public boolean dfs(int x1, int x2, int length) {
        if (memo[x1][x2][length] != 0) {
            return memo[x1][x2][length] == 1;
        }
        if (s1.substring(x1, x1 + length).equals(s2.substring(x2, x2 + length))) {
            memo[x1][x2][length] = 1;
            return true;
        }
        if (!check(x1, x2, length)) {
            memo[x1][x2][length] = -1;
            return false;
        }
        for (int i = 1; i < length; i++) {
            if (dfs(x1, x2, i) && dfs(x1 + i, x2 + i, length - i)) {
                memo[x1][x2][length] = 1;
                return true;
            }
            if (dfs(x1 + i, x2, length - i) && dfs(x1, x2 + length - i, i)) {
                memo[x1][x2][length] = 1;
                return true;
            }
        }
        memo[x1][x2][length] = -1;
        return false;
    }

    public boolean check(int x1, int x2, int length) {
        int[] arr = new int[26];
        for (int i = 0; i < length; i++) {
            arr[s1.charAt(x1 + i) - 'a']++;
            arr[s2.charAt(x2 + i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
