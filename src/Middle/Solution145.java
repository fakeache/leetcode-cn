package Middle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution145 {
    public class TreeNodePlus {
        public TreeNode tn;
        public boolean isTraversed;

        public TreeNodePlus(TreeNode tn) {
            this.tn = tn;
        }

        public void setTraverse(boolean isTraversed) {
            this.isTraversed = isTraversed;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rslist = new LinkedList<>();
        if (root == null) {
            return rslist;
        }
        Deque<TreeNodePlus> stack = new LinkedList<>();
        stack.push(new TreeNodePlus(root));
        while (!stack.isEmpty()) {
            TreeNodePlus tnp = stack.pop();
            if (!tnp.isTraversed) {
                tnp.setTraverse(true);
                stack.push(tnp);
                if (tnp.tn.right != null) {
                    stack.push(new TreeNodePlus(tnp.tn.right));
                }
                if (tnp.tn.left != null) {
                    stack.push(new TreeNodePlus(tnp.tn.left));
                }
            } else {
                rslist.add(tnp.tn.val);
            }
        }
        return rslist;
    }
}