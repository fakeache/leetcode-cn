package Simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution538 {
    static class TreeNodePlus {
        TreeNode t;
        boolean isTraverse;

        public TreeNodePlus(TreeNode tn) {
            this.t = tn;
        }

        public void setTraverse (boolean isTraverse) {
            this.isTraverse = isTraverse;
        }
    }
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNodePlus> stack = new LinkedList<>();
        TreeNodePlus tnp = new TreeNodePlus(root);
        stack.push(tnp);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNodePlus node = stack.pop();
            if (!node.isTraverse) {
                if (node.t.left != null) {
                    stack.push(new TreeNodePlus(node.t.left));
                }
                node.setTraverse(true);
                stack.push(node);
                if (node.t.right != null) {
                    stack.push(new TreeNodePlus(node.t.right));
                }
            } else {
                node.t.val += sum;
                sum = node.t.val;
            }
        }
        return root;
    }
}