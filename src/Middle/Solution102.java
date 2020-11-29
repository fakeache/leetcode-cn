package Middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rsList = new ArrayList<>();
        if (root == null) {
            return rsList;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int len = 1;
        List<Integer> rs = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            len--;
            rs.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (len == 0) {
                rsList.add(rs);
                rs = new ArrayList<>();
                len = queue.size();
            }

        }
        return rsList;
    }
}