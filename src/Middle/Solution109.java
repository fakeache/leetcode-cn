package Middle;

class Solution109 {

    public TreeNode sortedListToBST(ListNode head) {
        return sortListToTree(head, Integer.MAX_VALUE);
    }

    TreeNode sortListToTree(ListNode node, int val) {
        if (node == null || node.val >= val) {
            return null;
        }
        ListNode dummy = new ListNode(-1, node);
        ListNode pre = dummy, back = dummy;
        while (pre.next != null && pre.next.val < val) {
            pre = pre.next;
            back = back.next;
            if (pre.next != null && pre.next.val < val) {
                pre = pre.next;
            }
        }
        TreeNode head = new TreeNode(back.val);
        head.left = sortListToTree(node, back.val);
        head.right = sortListToTree(back.next, val);
        return head;
    }
}