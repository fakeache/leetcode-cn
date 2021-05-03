package Hard;

import java.util.*;

public class Solution126 {
    List<List<String>> rs = new LinkedList<>();
    Map<String, List<String>> map = new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int dlen = wordList.size();
        for (int i = 0; i < dlen; i++) {
            String wtmp = wordList.get(i);
            map.put(wtmp, new LinkedList<>());
        }
        map.put(endWord, new LinkedList<>());
        for (int i = 0; i < dlen; i++) {
            String wtmp = wordList.get(i);
            for (int j = i + 1; j < dlen; j++) {
                String wtmp1 = wordList.get(j);
                if (transfer(wtmp, wtmp1)) {
                    map.get(wtmp).add(wtmp1);
                    map.get(wtmp1).add(wtmp);
                }
            }
        }
        LinkedList<String> seq = new LinkedList<>();
        Set<String> set = new HashSet<>();
        seq.add(endWord);
        set.add(endWord);
        dfs(seq, beginWord, set, endWord);
        return rs;
    }

    public void dfs(LinkedList<String> seq, String beginWord, Set<String> set, String str) {
        if (rs.size() != 0 && seq.size() > rs.get(0).size() - 1) {
            return;
        }
        if (transfer(str, beginWord)) {
            LinkedList<String> ele = (LinkedList<String>) seq.clone();
            ele.add(0, beginWord);
            if (rs.size() != 0 && ele.size() < rs.get(0).size()) {
                rs.clear();
            }
            rs.add(ele);
            return;
        }
        List<String> list = map.get(str);
        for (String cur : list) {
            if (set.contains(cur)) {
                continue;
            }
            set.add(cur);
            seq.add(0, cur);
            dfs(seq, beginWord, set, cur);
            seq.remove(0);
            set.remove(cur);
        }
    }

    public boolean transfer(String x, String y) {
        int len = x.length();
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (x.charAt(i) != y.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
