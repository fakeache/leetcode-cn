package Middle;

import java.util.Deque;
import java.util.LinkedList;

class Solution200 {
    public int numIslands(char[][] grid) {
        int num = 0;
        int x = grid.length;
        int y = grid[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    Deque<int[]> queue = new LinkedList<>();
                    int[] root = {i, j};
                    grid[i][j] = '0';
                    queue.addLast(root);
                    while (!queue.isEmpty()) {
                        int[] ele = queue.removeFirst();
                        if (ele[0] < x - 1 && grid[ele[0] + 1][ele[1]] == '1') {
                            grid[ele[0] + 1][ele[1]] = '0';
                            int[] tmp = {ele[0] + 1, ele[1]};
                            queue.addLast(tmp);
                        }
                        if (ele[1] < y - 1 && grid[ele[0]][ele[1] + 1] == '1') {
                            grid[ele[0]][ele[1] + 1] = '0';
                            int[] tmp = {ele[0], ele[1] + 1};
                            queue.addLast(tmp);
                        }
                        if (ele[0] > 0 && grid[ele[0] - 1][ele[1]] == '1') {
                            grid[ele[0] - 1][ele[1]] = '0';
                            int[] tmp = {ele[0] - 1, ele[1]};
                            queue.addLast(tmp);
                        }
                        if (ele[1] > 0 && grid[ele[0]][ele[1] - 1] == '1') {
                            grid[ele[0]][ele[1] - 1] = '0';
                            int[] tmp = {ele[0], ele[1] - 1};
                            queue.addLast(tmp);
                        }
                    }
                }
            }
        }
        return num;
    }
}