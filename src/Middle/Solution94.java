package Middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 颜色标记法 不使用递归的迭代遍历算法
 */
class Solution94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class TreeNodePlus {
        TreeNode node;
        boolean status;

        public TreeNodePlus(TreeNode node, boolean status) {
            this.node = node;
            this.status = status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNodePlus> stack = new LinkedList<>();
        if (root != null) {
            TreeNodePlus rootp = new TreeNodePlus(root, false);
            stack.push(rootp);
        }
        while (!stack.isEmpty()) {
            TreeNodePlus tnp = stack.pop();
            if (!tnp.status) {
                if (tnp.node.right != null) {
                    TreeNodePlus noder = new TreeNodePlus(tnp.node.right, false);
                    stack.push(noder);
                }
                tnp.setStatus(true);
                stack.push(tnp);
                if (tnp.node.left != null) {
                    TreeNodePlus nodel = new TreeNodePlus(tnp.node.left, false);
                    stack.push(nodel);
                }
            } else {
                res.add(tnp.node.val);
            }
        }
        return res;
    }
}