package Hard;

import Middle.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution99 {
    public void recoverTree(TreeNode root) {
        TreeNode pre = null, x = null, y = null;
        Deque<TreeNode> stk = new LinkedList<>();
        while (!stk.isEmpty() || root != null) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if (pre != null) {
                if (root.val < pre.val) {
                    y = root;
                    if (x == null) {
                        x = pre;
                    } else {
                        break;
                    }
                }
            }
            pre = root;
            root = root.right;
        }
        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
