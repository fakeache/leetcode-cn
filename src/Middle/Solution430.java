package Middle;

import java.util.Deque;
import java.util.LinkedList;

class Node430 {
    public int val;
    public Node430 prev;
    public Node430 next;
    public Node430 child;
}

public class Solution430 {
    public Node430 flatten(Node430 head) {
        if (head == null) {
            return head;
        }
        Deque<Node430> stk = new LinkedList<>();
        stk.push(head);
        Node430 cur = null;
        while (!stk.isEmpty()) {
            Node430 Node430 = stk.pop();
            if (cur != null) {
                Node430.prev = cur;
                cur.next = Node430;
            }
            cur = Node430;
            if (Node430.next != null) {
                stk.push(Node430.next);
            }
            if (Node430.child != null) {
                stk.push(Node430.child);
            }
            Node430.child = null;
        }
        return head;
    }
}
