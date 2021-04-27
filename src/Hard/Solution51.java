package Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution51 {
    List<List<String>> rs = new LinkedList<>();
    boolean[] row;
    boolean[] col;
    int n;
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return rs;
        }
        this.n = n;
        row = new boolean[n];
        col = new boolean[n];
        char[][] plate = new char[n][n];
        dfs(plate, 0, 0, 0);
        return rs;
    }

    public void dfs(char[][] plate, int x, int y, int count) {
        if (count > n) {
            return;
        }
        if (x == n && y == 0) {
            if (count == n) {
                List<String> ele = new ArrayList<>(4);
                for (int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        sb.append(plate[i][j]);
                    }
                    ele.add(sb.toString());
                }
                rs.add(ele);
            }
            return;
        }
        int nextX = x;
        int nextY = y;
        if (y == n - 1) {
            nextX++;
            nextY = 0;
        } else {
            nextY++;
        }
        boolean angle = false;
        int m = x, l = y;
        while (!angle && m >= 0 && l >= 0) {
            if (plate[m][l] == 'Q') {
                angle = true;
                break;
            }
            m--;
            l--;
        }
        m = x;
        l = y;
        while (!angle && m >= 0 && l < n) {
            if (plate[m][l] == 'Q') {
                angle = true;
                break;
            }
            m--;
            l++;
        }
        if (!row[x] && !col[y] && !angle) {
            plate[x][y] = 'Q';
            row[x] = true;
            col[y] = true;
            dfs(plate, nextX, nextY, count + 1);
            row[x] = false;
            col[y] = false;
        }

        plate[x][y] = '.';
        dfs(plate, nextX, nextY, count);


    }
}
