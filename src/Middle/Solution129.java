package Middle;

class Solution129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        dfs(root, 0);
        return sum;
    }
    void dfs(TreeNode node, int num) {
        int cur = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += cur;
            return;
        }
        if (node.left != null) {
            dfs(node.left, cur);
        }
        if (node.right != null) {
            dfs(node.right, cur);
        }
    }
}