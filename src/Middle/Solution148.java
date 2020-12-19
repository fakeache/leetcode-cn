package Middle;

class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode other = slow.next;
        slow.next = null;
        head = sortList(head);
        other = sortList(other);
        return merge(head, other);
    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int sub = 1; sub < len; sub = sub << 1) {
            ListNode pre = dummy, cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < sub && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < sub && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                cur = next;
                ListNode m = merge(head1, head2);
                pre.next = m;
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }

    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (one != null && two != null) {
            if (one.val <= two.val) {
                p.next = one;
                p = one;
                one = one.next;
            } else {
                p.next = two;
                p = two;
                two = two.next;
            }
        }
        if (one != null) {
            p.next = one;
        } else if (two != null){
            p.next = two;
        }
        return dummy.next;
    }
}