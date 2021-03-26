package Middle;

class Solution236 {

    TreeNode node;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return node;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean lrs = dfs(node.left, p, q);
        boolean rrs = dfs(node.right, p, q);
        if (lrs == true && rrs == true || (p == node || q == node) && (lrs || rrs)) {
            this.node = node;
        }
        return lrs || rrs || p == node || q == node;
    }
}
