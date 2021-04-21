package Middle;

import java.util.LinkedList;
import java.util.Queue;

public class Solution449 {
    public void build(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        sb.append(" ");
        build(node.left, sb);
        build(node.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }

    public TreeNode helper(int min, int max, Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        int first = queue.peek();
        if (first < min || first > max) {
            return null;
        }
        first = queue.poll();
        TreeNode node = new TreeNode(first);
        node.left = helper(min, first, queue);
        node.right = helper(first, max, queue);
        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (String str : data.split(" ")) {
            queue.add(Integer.valueOf(str));
        }
        return helper(0, Integer.MAX_VALUE, queue);
    }
}
