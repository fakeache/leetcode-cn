package Middle;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((m, n) -> n[1] - m[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] ele = new int[]{entry.getKey(), entry.getValue()};
            queue.add(ele);
        }
        int[] rs = new int[k];
        for (int j = 0; j < k; j++) {
            int[] temp = queue.poll();
            rs[j] = temp[0];
        }
        return rs;
    }
}
