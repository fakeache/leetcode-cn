package Middle;

import java.util.LinkedList;

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();
        int x = newInterval[0];
        int y = newInterval[1];
        int i = 0;
        for (; i < intervals.length; i++) {
            int[] ele = intervals[i];
            if (ele[1] < x) {
                list.add(ele);
            } else {
                break;
            }
        }
        if (i == intervals.length) {
            list.add(newInterval);
            return list.toArray(new int[list.size()][2]);
        }
        int[] newArr = new int[2];
        newArr[0] = Math.min(x, intervals[i][0]);
        for (; i < intervals.length; i++) {
            int[] ele = intervals[i];
            if (y < ele[0]) {
                break;
            }
        }
        newArr[1] = i > 0 ? Math.max(y, intervals[i - 1][1]) : y;
        list.add(newArr);
        for (int l = i; l < intervals.length; l++) {
            list.add(intervals[l]);
        }
        return list.toArray(new int[list.size()][2]);
    }
}