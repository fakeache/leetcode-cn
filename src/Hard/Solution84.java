package Hard;

import java.util.Deque;
import java.util.LinkedList;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            left[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        stk.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            right[i] = stk.isEmpty() ? len : stk.peek();
            stk.push(i);
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }
}
