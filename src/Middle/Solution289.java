package Middle;

class Solution289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0, dead = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int p = -1; p <= 1; p++) {
                        if (i + k < 0 || i + k >= m || j + p < 0 || j + p >= n) {
                            continue;
                        }
                        if (k == 0 && p == 0) {
                            continue;
                        }
                        if (board[i + k][j + p] == 0 || board[i + k][j + p] == 2) {
                            dead++;
                        } else {
                            live++;
                        }
                    }
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
