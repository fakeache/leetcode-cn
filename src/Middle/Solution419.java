package Middle;

public class Solution419 {
    public int countBattleships(char[][] board) {
        int count = 0;
        if (board == null || board.length == 0 || board[0].length == 0) {
            return count;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    for (int k = j + 1; k < n && board[i][k] == 'X'; k++) {
                        board[i][k] = '.';
                    }
                    for (int k = i + 1; k < m && board[k][j] == 'X'; k++) {
                        board[k][j] = '.';
                    }
                }
            }
        }
        return count;
    }
}
