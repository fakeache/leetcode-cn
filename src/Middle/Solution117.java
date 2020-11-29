package Middle;

import java.util.Deque;
import java.util.LinkedList;

class Solution117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == size - 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
            }
        }
        return root;
    }
}
