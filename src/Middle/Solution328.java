package Middle;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, p = head, even = head.next, q = head.next;
        while (p != null) {
            if (q == null || q.next == null) {
                break;
            }
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;
        }
        p.next = even;
        return odd;
    }
}
