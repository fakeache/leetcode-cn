package Middle;
class Node427 {
    public boolean val;
    public boolean isLeaf;
    public Node427 topLeft;
    public Node427 topRight;
    public Node427 bottomLeft;
    public Node427 bottomRight;


    public Node427() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node427(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node427(boolean val, boolean isLeaf, Node427 topLeft, Node427 topRight, Node427 bottomLeft, Node427 bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

public class Solution427 {
    int[][] grid;
    public Node427 construct(int[][] grid) {
        this.grid = grid;
        return dfs(0, 0, grid.length - 1, grid[0].length - 1);
    }

    public Node427 dfs(int a, int b, int c, int d) {
        if (a == c || b == d) {
            return new Node427(grid[a][b] == 1, true);
        }
        Node427 topLeft = dfs(a, b, (a + c) / 2, (b + d) / 2);
        Node427 topRight = dfs(a, (b + d) / 2 + 1, (a + c) / 2, d);
        Node427 bottomLeft = dfs((a + c) / 2 + 1, b, c, (b + d) / 2);
        Node427 bottomRight = dfs((a + c) / 2 + 1, (b + d) / 2 + 1, c, d);
        boolean andVal = topLeft.val && topRight.val && bottomLeft.val && bottomRight.val;
        boolean orVal = topLeft.val || topRight.val || bottomLeft.val || bottomRight.val;
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf
                && bottomRight.isLeaf && (andVal || !orVal)) {
            return new Node427(topLeft.val, true);
        }
        return new Node427(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
