package Middle;

class Solution230 {
    private int val;
    private int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return val;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        count--;
        if (count == 0) {
            val = node.val;
        }
        dfs(node.right);
    }
}
