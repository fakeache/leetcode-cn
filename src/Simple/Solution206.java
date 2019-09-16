package Simple;

public class Solution206 {
    //非递归解法
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        while (head != null) {
            ListNode q = head.next;
            head.next = p;
            p = head;
            head = q;
        }
        return p;
    }
    //递归解法
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}