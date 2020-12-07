package Middle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }
                String back = s.substring(j, i);
                if (set.contains(back)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }


    boolean[] isVisited;
    public boolean wordBreak1(String s, List<String> wordDict) {
        isVisited = new boolean[s.length()];
        return dfs(s, new HashSet<String>(wordDict), 0, s.length() - 1);
    }

    public boolean dfs(String s, Set<String> wordDict, int begin, int end) {
        if (begin > end) {
            return true;
        }
        if (isVisited[begin]) {
            return false;
        }
        for (int i = begin; i <= end; i++) {
            String pre = s.substring(begin, i + 1);
            if (!wordDict.contains(pre)) {
                continue;
            }
            if (dfs(s, wordDict, i + 1, end)) {
                return true;
            }
        }
        isVisited[begin] = true;
        return false;
    }
}
