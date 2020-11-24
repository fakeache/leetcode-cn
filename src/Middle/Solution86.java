package Middle;

class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        ListNode q = dummy;
        ListNode ndum = new ListNode(-1);
        ndum.next = null;
        ListNode m = ndum;
        while (p != null) {
            if (p.val < x) {
                q.next = p.next;
                m.next = p;
                m = p;
                p = q.next;
            } else {
                q = p;
                p = p.next;
            }
        }
        m.next = dummy.next;
        return ndum.next;
    }
}
