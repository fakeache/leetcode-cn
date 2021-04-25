package Hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rs = new LinkedList<>();
        if (s == null || s.length() == 0 || words == null
                || words.length == 0 || words[0].length() == 0) {
            return rs;
        }
        int slen = s.length(), arrlen = words.length, wlen = words[0].length();
        HashMap<String, Integer> originMap = new HashMap<>();
        for (String word : words) {
            originMap.put(word, originMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wlen; i++) {
            int begin = i, j = i;
            HashMap<String, Integer> map = (HashMap) originMap.clone();
            while (j + wlen <= slen) {
                String win = s.substring(j, j + wlen);
                if (map.containsKey(win)) {
                    int count = map.get(win);
                    if (count == 1) {
                        map.remove(win);
                        if (map.isEmpty()) {
                            rs.add(begin);
                        }
                    } else {
                        map.put(win, count - 1);
                    }
                    j += wlen;
                } else {
                    if (originMap.containsKey(win)) {
                        String cur = s.substring(begin, begin + wlen);
                        map.put(cur, map.getOrDefault(cur, 0) + 1);
                        begin = begin + wlen;
                    } else {
                        begin = j + wlen;
                        j += wlen;
                        map = (HashMap) originMap.clone();
                    }

                }
            }
        }
        return rs;
    }
}
