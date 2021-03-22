package Middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rsList = new ArrayList<>();
        if (root == null) {
            return rsList;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        rsList.add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            if (!queue.isEmpty()) {
                rsList.add(queue.getLast().val);
            }
        }
        return rsList;
    }
}
