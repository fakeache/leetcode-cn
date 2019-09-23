package Simple;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int half = len / 2;
        int t = len % 2;
        p = null;
        ListNode q = head;
        ListNode l = q.next;
        while (half-- > 0) {
            q.next = p;
            p = q;
            q = l;
            l = l.next;
        }
        ListNode right;
        if (t == 1) {
            right = l;
        } else {
            right = q;
        }
        while (p != null && right != null) {
            if (p.val != right.val) {
                return false;
            } else {
                p = p.next;
                right = right.next;
            }
        }
        if (p == null && right == null) {
            return true;
        } else {
            return false;
        }
    }
}
