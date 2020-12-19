package Middle;

class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head.next, m = head;
        while (p != null) {
            ListNode q = dummy, t = dummy.next;
            while (p.val > t.val) {
                q = t;
                t = t.next;
            }
            if (t != p) {
                m.next = p.next;
                p.next = t;
                q.next = p;
                p = m.next;
            } else {
                m = p;
                p = m.next;
            }
        }
        return dummy.next;
    }
}
