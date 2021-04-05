package Middle;

import java.util.*;

public class Solution332 {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> rs = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            if (map.get(from) == null) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).add(ticket.get(1));
        }
        dfs("JFK");
        Collections.reverse(rs);
        return rs;
    }

    public void dfs(String p) {
        PriorityQueue<String> queue = map.get(p);
        while (queue != null && !queue.isEmpty()) {
            String next = queue.poll();
            dfs(next);
        }
        rs.add(p);
    }
}
