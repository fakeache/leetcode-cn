package Middle;

import java.util.Arrays;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> o1[1] < o2[1] ? -1 : 1);
        int count = 1;
        int end = points[0][1];
        int len = points.length;
        for (int i = 1; i < len; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution452().findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));;
    }
}
