package Hard;

public class Solution52 {
    public int totalNQueens(int n) {
        return dfs(n, 0, 0, 0, 0);
    }

    public int dfs(int n, int row, int place, int lu, int ru) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        int cur = (1 << n) - 1 & (~(place | lu | ru));
        while (cur != 0) {
            int last = cur & (-cur);
            cur = cur & (cur - 1);
            count += dfs(n, row + 1, place | last, (lu | last) >> 1, (ru | last) << 1);
        }
        return count;
    }
}
