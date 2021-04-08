package Middle;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution365 {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Deque<int[]> stk = new LinkedList<>();
        Set<Long> set = new HashSet<>();
        stk.push(new int[]{0, 0});
        while (!stk.isEmpty()) {
            int[] ele = stk.pop();
            int remain_x = ele[0], remain_y = ele[1];
            long hash = hash(remain_x, remain_y);
            if (set.contains(hash)) {
                continue;
            }
            set.add(hash);
            if (remain_x == targetCapacity || remain_y == targetCapacity
                    || remain_x + remain_y == targetCapacity) {
                return true;
            }
            stk.push(new int[]{jug1Capacity, remain_y});
            stk.push(new int[]{remain_x, jug2Capacity});
            stk.push(new int[]{0, remain_y});
            stk.push(new int[]{remain_x, 0});
            int t = Math.min(remain_x, jug2Capacity - remain_y);
            stk.push(new int[]{remain_x - t, remain_y + t});
            t = Math.min(remain_y, jug1Capacity - remain_x);
            stk.push(new int[]{remain_x + t, remain_y - t});
        }
        return false;
    }

    public long hash(int x, int y) {
        return  (long) x * 1000001 + y;
    }
}
