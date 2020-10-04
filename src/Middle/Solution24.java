package Middle;

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode t = dummy;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode q = p.next.next;
            p.next.next = p;
            t.next = p.next;
            p.next = q;
            t = p;
            p = q;
        }
        return dummy.next;
    }
}
