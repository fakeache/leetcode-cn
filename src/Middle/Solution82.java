package Middle;

// 思路想错了，做到怀疑人生。瞄了一眼答案才理顺思维
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head;
        ListNode back = dummy;
        while (pre != null && pre.next != null) {
            if (pre.val != pre.next.val) {
                back.next = pre;
                back = pre;
                pre = pre.next;
            } else {
                while (pre.next != null && pre.val == pre.next.val) {
                    pre = pre.next;
                }
                pre = pre.next;
            }
        }
        back.next = pre;
        return dummy.next;
    }
}