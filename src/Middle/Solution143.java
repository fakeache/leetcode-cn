package Middle;

public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 找到中位节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode back = slow.next;
        slow.next = null;
        //链表逆序
        ListNode t = null, q = back, p = back.next;
        while (p != null) {
            q.next = t;
            t = q;
            q = p;
            p = p.next;
        }
        q.next = t;
        //合并链表
        ListNode x = head, y = head;
        while (q != null) {
            p = q;
            q = q.next;
            x = y;
            y = y.next;
            p.next = y;
            x.next = p;
        }
    }
}
