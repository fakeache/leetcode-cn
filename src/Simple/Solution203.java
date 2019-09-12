package Simple;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode q = head;
        while (q != null) {
            if (q.val == val) {
                if (head == q) {
                    head = head.next;
                }
                q = q.next;
                p.next = q;
            }
            else {
                q = q.next;
                p = p.next;
            }
        }
        return head;
    }
}
