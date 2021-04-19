package Middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(intervals[i], i);
        }
        int[] rs = new int[len];
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < len; i++) {
            int[] cur = intervals[i];
            int low = i, high = len - 1;
            if (intervals[high][0] < cur[1]) {
                rs[map.get(cur)] = -1;
                continue;
            }
            while (low < high) {
                int mid = (low + high) / 2;
                if (intervals[mid][0] < cur[1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            rs[map.get(cur)] = map.get(intervals[low]);
        }
        return rs;
    }
}
