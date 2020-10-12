package Middle;

class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode l = head;
        while (l.next != null) {
            l = l.next;
            len++;
        }
        l.next = head;
        ListNode begin = head;
        for (int i = 1; i < len - k % len; i++) {
            begin = begin.next;
        }
        ListNode rs = begin.next;
        begin.next = null;
        return rs;
    }
}