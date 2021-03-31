package Middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution310 {

    List<Integer> rs;
    List<List<Integer>> rel = new ArrayList<>();
    int[] neighbor;
    Queue<Integer> queue = new LinkedList<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            rs = new ArrayList<>();
            rs.add(0);
            return rs;
        }
        neighbor = new int[n];
        for (int i = 0; i < n; i++) {
            rel.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            neighbor[edges[i][0]]++;
            neighbor[edges[i][1]]++;
            rel.get(edges[i][0]).add(edges[i][1]);
            rel.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (neighbor[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            rs = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int ele = queue.poll();
                rs.add(ele);
                List<Integer> list = rel.get(ele);
                for (int x : list) {
                    neighbor[x]--;
                    if (neighbor[x] == 1) {
                        queue.add(x);
                    }
                }
            }
        }
        return rs;
    }

}