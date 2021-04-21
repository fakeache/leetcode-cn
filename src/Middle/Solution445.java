package Middle;

import java.util.Deque;
import java.util.LinkedList;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stk1 = new LinkedList<>();
        Deque<ListNode> stk2 = new LinkedList<>();
        while (l1 != null) {
            stk1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stk2.push(l2);
            l2 = l2.next;
        }
        int x3 = 0;
        ListNode rs = null;
        while (!stk1.isEmpty() || !stk2.isEmpty()) {
            int x1 = 0, x2 = 0;
            if (!stk1.isEmpty()) {
                x1 = stk1.pop().val;
            }
            if (!stk2.isEmpty()) {
                x2 = stk2.pop().val;
            }
            rs = new ListNode((x1 + x2 + x3) % 10, rs);
            x3 = (x1 + x2 + x3) / 10;
        }
        if (x3 != 0) {
            rs = new ListNode(x3, rs);
        }
        return rs;
    }
}
