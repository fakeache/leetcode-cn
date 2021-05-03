package Hard;

import java.util.Deque;
import java.util.LinkedList;

public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                }
            }
        }
        int rs = 0;
        Deque<Integer> stk = new LinkedList<>();
        int[] up;
        int[] down;
        for (int j = 0; j < n; j++) {
            up = new int[m];
            down = new int[m];
            stk.clear();
            for (int i = 0; i < m; i++) {
                while (!stk.isEmpty() && left[stk.peek()][j] >= left[i][j]) {
                    stk.pop();
                }
                up[i] = stk.isEmpty() ? -1 : stk.peek();
                stk.push(i);
            }
            stk.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stk.isEmpty() && left[stk.peek()][j] >= left[i][j]) {
                    stk.pop();
                }
                down[i] = stk.isEmpty() ? m : stk.peek();
                stk.push(i);
            }
            for (int i = 0; i < m; i++) {
                rs = Math.max(rs, left[i][j] * (down[i] - up[i] - 1));
            }
        }
        return rs;
    }
}
