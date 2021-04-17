package Middle;

import java.util.*;

public class Solution431 {
    public int minMutation(String start, String end, String[] bank) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < bank.length; i++) {
            if (map.containsKey(bank[i])) {
                continue;
            }
            map.put(bank[i], new LinkedList<>());
            for (int j = 0; j < i; j++) {
                if (validChange(bank[i], bank[j])) {
                    map.get(bank[i]).add(bank[j]);
                    map.get(bank[j]).add(bank[i]);
                }
            }
        }
        if (!map.containsKey(end)) {
            return -1;
        }
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(end);
        visited.add(end);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String ele = queue.poll();
                visited.add(ele);
                if (validChange(ele, start)) {
                    return count;
                }
                for (String str : map.get(ele)) {
                    if (!visited.contains(str)) {
                        queue.add(str);
                    }
                }
            }
        }
        return -1;
    }
    public boolean validChange(String var1, String var2) {
        int count = 0;
        for (int i = 0; i < var1.length(); i++) {
            if (var1.charAt(i) != var2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
