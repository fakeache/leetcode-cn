package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        List<int[]> rslist = new ArrayList<>();
        Arrays.sort(intervals, (int[] a1, int[] a2) -> a1[0] - a2[0]);
        int[] arr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] tarr = intervals[i];
            if (tarr[0] > arr[1]) {
                rslist.add(arr);
                arr = tarr;
            } else {
                arr[1] = Math.max(arr[1], tarr[1]);
            }
        }
        rslist.add(arr);
        return rslist.toArray(new int[rslist.size()][2]);
    }

    public static void main(String[] args) {
        Solution56 solution = new Solution56();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}