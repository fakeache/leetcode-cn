package Middle;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        int level = 0;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int left = 1 << level, right = (1 << (level + 1)) - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (exist(root, mid, level)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean exist(TreeNode root, int k, int level) {
        int m = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && m > 0) {
            if ((m & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            m = m >> 1;
        }
        return node != null;
    }
}
