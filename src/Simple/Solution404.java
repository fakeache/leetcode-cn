package Simple;

import java.util.Deque;
import java.util.LinkedList;

class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t.left != null) {
                if (t.left.left == null && t.left.right ==null) {
                    sum += t.left.val;
                }
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
        }
        return sum;
    }
}