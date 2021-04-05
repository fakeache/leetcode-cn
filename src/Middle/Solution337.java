package Middle;

public class Solution337 {
    public int rob(TreeNode root) {
        // 0盗取该节点，1不盗取该节点
        return Math.max(dfs(root)[0], dfs(root)[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] rs = new int[2];
        rs[0] = node.val + left[1] + right[1];
        rs[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return rs;
    }
}
