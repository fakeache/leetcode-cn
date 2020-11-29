package Middle;

import java.util.Deque;
import java.util.LinkedList;

class Solution116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        int x = 1;
        int s = 0;
        while (!queue.isEmpty()) {
            Node t = queue.poll();
            if (t.left != null && t.right != null) {
                queue.add(t.left);
                queue.add(t.right);
            }
            if (++s == x) {
                t.next = null;
                x *= 2;
                s = 0;
            } else {
                t.next = queue.peek();
            }
        }
        return root;
    }
}