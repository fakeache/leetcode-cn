package Middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer>[] row = new HashMap[9];
        Map<Character, Integer>[] column = new HashMap[9];
        Map<Character, Integer>[] block = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<Character, Integer>();
            column[i] = new HashMap<Character, Integer>();
            block[i] = new HashMap<Character, Integer>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int index = (i / 3) * 3 + j / 3;
                if (row[i].containsKey(c) || column[j].containsKey(c) || block[index].containsKey(c)) {
                    return false;
                }
                row[i].put(c, 1);
                column[j].put(c, 1);
                block[index].put(c, 1);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution36 solution = new Solution36();
        char[][] arr = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(solution.isValidSudoku(arr));
    }
}