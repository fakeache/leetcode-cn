package Middle;

class Solution79 {
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (check(board, i, j, visited, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int i, int j, boolean[][] visited, int k, String word) {
        // 剪枝， board当前元素和word当前元素不相等
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        // word最后一个元素也匹配上了，则word完全匹配了
        if (k == word.length() - 1) {
            return true;
        }
        // 当前元素相等，且word还有需要匹配的字符，检查board邻近的节点。将遍历过的board置为true
        visited[i][j] = true;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : direction) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length && !visited[newi][newj]) {
                if (check(board, newi, newj, visited, k+1, word)) {
                    return true;
                }
            }
        }
        // 邻近节点都匹配失败了，回溯当前节点
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(solution79.exist(board, word));
    }
}
