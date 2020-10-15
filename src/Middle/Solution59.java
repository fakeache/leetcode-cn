package Middle;

class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] rs = new int[n][n];
        int s = 0;
        int x = 0;
        int y = n - 2;
        while (x <= y) {
            for (int i = x; i <= y; i++) {
                rs[x][i] = ++s;
            }
            for (int i = x; i <= y; i++) {
                rs[i][y + 1] = ++s;
            }
            for (int i = y + 1; i > x; i--) {
                rs[y + 1][i] = ++s;
            }
            for (int i = y + 1; i > x; i--) {
                rs[i][x] = ++s;
            }
            x++;
            y--;
        }
        if (x - 1 == y) {
            rs[x][x] = ++s;
        }
        return rs;
    }
}
