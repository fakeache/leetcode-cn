package Hard;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode p = head;
        int count = k;
        while (p != null && count > 0) {
            p = p.next;
            count--;
        }
        if (count > 0) {
            return head;
        }
        p = reverseKGroup(p, k);
        ListNode q = head;
        count = k;
        while (count > 0) {
            ListNode l = q.next;
            q.next = p;
            p = q;
            q = l;
            count--;
        }
        return p;
    }
}
