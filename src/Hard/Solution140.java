package Hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution140 {
    List<String> rs = new LinkedList<>();
    int len;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        this.len = s.length();
        dfs(s, 0, set, new StringBuilder());
        return rs;
    }

    public void dfs(String s, int begin, Set<String> set, StringBuilder sb) {
        if (begin == len) {
            rs.add(sb.toString().substring(0, sb.length() - 1));
            return;
        }
        for (int i = begin; i < len; i++) {
            String str = s.substring(begin, i + 1);
            if (!set.contains(str)) {
                continue;
            }
            int alen = str.length();
            sb.append(str).append(" ");
            dfs(s, i + 1, set, sb);
            sb.delete(sb.length() - alen - 1, sb.length());
        }
    }
}
