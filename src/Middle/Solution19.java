package Middle;

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = new ListNode(0);
        front.next = head;
        ListNode back = front, p = front;
        int count = 0;
        while (front.next != null) {
            if (count >= n) {
                back = back.next;
            }
            front = front.next;
            count++;
        }
        back.next = back.next.next;
        return p.next;
    }

    public static void main(String[] args) {
        Solution19 solution = new Solution19();
        ListNode node = new ListNode(1);
        node.next = null;
        System.out.println(solution.removeNthFromEnd(node, 1));
    }
}