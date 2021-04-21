package Middle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution451 {
    public String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] sarr = s.toCharArray();
        for (char c : sarr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new LinkedList<>();
            }
            buckets[freq].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            List<Character> l = buckets[i];
            if (l == null) {
                continue;
            }
            for (char c : l) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
