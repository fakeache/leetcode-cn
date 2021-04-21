package Middle;

import java.util.HashMap;
import java.util.Map;

public class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int xdis = points[i][0] - points[j][0];
                int ydis = points[i][1] - points[j][1];
                int dis = xdis * xdis + ydis * ydis;
                int value = map.getOrDefault(dis, 0) + 1;
                map.put(dis, value);
                if (value >= 2) {
                    count += 2 * (value - 1);
                }
            }
        }
        return count;
    }
}
