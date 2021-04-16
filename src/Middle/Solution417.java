package Middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution417 {

    int[][] heights;
    int m;
    int n;
    int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> rs = new LinkedList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return rs;
        }
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        boolean[][] visitedP = new boolean[m][n];
        boolean[][] visitedX = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, visitedP);
            dfs(i, n - 1, visitedX);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, visitedP);
            dfs(m - 1, i, visitedX);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedP[i][j] && visitedX[i][j]) {
                    List<Integer> ele = new ArrayList<Integer>();
                    ele.add(i);
                    ele.add(j);
                    rs.add(ele);
                }
            }
        }
        return rs;
    }

    public void dfs(int x, int y, boolean[][] visited) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int[] direction : dir) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if (!isValid(nextX, nextY) || heights[nextX][nextY] < heights[x][y]) {
                continue;
            }
            dfs(nextX, nextY, visited);
        }
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
