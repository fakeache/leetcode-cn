package Middle;

import java.util.Arrays;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int count = 1;
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pre) {
                count++;
                pre = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
