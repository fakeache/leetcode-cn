package Middle;

import java.util.ArrayList;
import java.util.List;

class Solution131 {
    List<List<String>> rsList = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return rsList;
        }
        dfs(s, new ArrayList<>(), 0, s.length() - 1);
        return rsList;
    }

    void dfs(String s, List<String> list, int begin, int end) {
        if (begin > end) {
            rsList.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i <= end; i++) {
            if (!isWord(s, begin, i)) {
                continue;
            }
            list.add(s.substring(begin, i + 1));
            dfs(s, list, i + 1, end);
            list.remove(list.size() - 1);
        }
    }

    boolean isWord(String s, int begin, int end) {
        int x = begin, y = end;
        while (x < y) {
            if (s.charAt(x) != s.charAt(y)) {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }
}