package Simple;

import java.util.LinkedList;
import java.util.Queue;

public class Solution235 {
    public boolean whetherSon(TreeNode x, TreeNode y) {
        while (true) {
            if (x == null || y == null) {
                return false;
            }
            if (x.val == y.val) {
                return true;
            } else if (x.val > y.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (whetherSon(node, p) && whetherSon(node, q) && node.val >= Math.min(p.val, q.val) && node.val <= Math.max(p.val, q.val)){
                return node;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (rVal > pVal && rVal > qVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (rVal < pVal && rVal < qVal) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
