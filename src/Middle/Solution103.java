package Middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rsList = new ArrayList<>();
        if (root == null) {
            return rsList;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int o = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> rs = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (o == 0) {
                    rs.add(node.val);
                } else {
                    rs.add(0, node.val);
                }
            }
            rsList.add(rs);
            o = o == 0 ? 1 : 0;
        }
        return rsList;
    }
}
