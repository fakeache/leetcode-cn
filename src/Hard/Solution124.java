package Hard;

import Middle.TreeNode;

public class Solution124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxValue(root);
        return maxSum;
    }

    public int maxValue(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(maxValue(node.left), 0);
        int right = Math.max(maxValue(node.right), 0);
        maxSum = Math.max(maxSum, node.val + left + right);
        return left > right ? node.val + left : node.val + right;
    }
}
