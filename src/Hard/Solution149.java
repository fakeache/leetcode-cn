package Hard;

import java.util.HashMap;
import java.util.Map;

public class Solution149 {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len < 3) {
            return len;
        }
        int rs = 0;
        for (int i = 0; i < len; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int xi = points[i][0];
            int yi = points[i][1];
            int dup = 0;
            int hori = 0;
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                int xj = points[j][0];
                int yj = points[j][1];
                if (xi == xj && yi == yj) {
                    dup++;
                } else if (xj == xi) {
                    hori++;
                    count = Math.max(count, hori);
                }
                double k = 1.0 * (yj - yi) / (xj - xi) + 0.0;
                map.put(k, map.getOrDefault(k, 0) + 1);
                count = Math.max(map.get(k), count);
            }
            rs = Math.max(rs, count + dup);
        }
        return rs + 1;
    }
}
