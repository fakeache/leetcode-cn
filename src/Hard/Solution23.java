package Hard;

import Hard.ListNode;

import java.util.PriorityQueue;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode rs = null, p = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode ln : lists) {
            if (ln != null) {
                queue.add(ln);
            }
        }
        while (!queue.isEmpty()) {
            ListNode ln = queue.poll();
            if (rs == null) {
                rs = ln;
                p = ln;
            } else {
                p.next = ln;
                p = p.next;
            }
            ln = ln.next;
            if (ln != null) {
                queue.add(ln);
            }
        }
        if (p != null) {
            p.next = null;
        }
        return rs;
    }
}
