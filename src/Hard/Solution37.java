package Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution37 {
    char[][] rs = new char[9][9];;

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = rs[i][j];
            }
        }
    }

    public boolean dfs(char[][] board, int x, int y) {
        if (x == 9 && y == 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    rs[i][j] = board[i][j];
                }
            }
            return true;
        }
        int nextX = x, nextY = y;
        if (y == 8) {
            nextX++;
            nextY = 0;
        } else {
            nextY++;
        }
        if (board[x][y] != '.') {
            return dfs(board, nextX, nextY);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[x][i] != '.') {
                set.add(board[x][i] - '0');
            }
            if (board[i][y] != '.') {
                set.add(board[i][y] - '0');
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[x / 3 * 3 + i][y / 3 * 3 + j];
                if (c != '.') {
                    set.add(c - '0');
                }
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (!set.contains(i)) {
                char addc = (char)('0' + i);
                board[x][y] = addc;
                boolean son = dfs(board, nextX, nextY);
                board[x][y] = '.';
                if (son) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("\n");
        new Solution37().solveSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
    }
}
