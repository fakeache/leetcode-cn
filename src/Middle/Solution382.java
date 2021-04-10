package Middle;

import java.util.Random;

public class Solution382 {
    ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution382(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int k = 1;
        int rs = 0;
        ListNode node = head;
        Random random = new Random();
        while (node != null) {
            if (random.nextInt(k) == 0) {
                rs = node.val;
            }
            node = node.next;
            k++;
        }
        return rs;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(new Solution382(node1).getRandom());
        System.out.println(new Solution382(node1).getRandom());
        System.out.println(new Solution382(node1).getRandom());
        System.out.println(new Solution382(node1).getRandom());
        System.out.println(new Solution382(node1).getRandom());
        System.out.println(new Solution382(node1).getRandom());
        System.out.println(new Solution382(node1).getRandom());
        System.out.println(new Solution382(node1).getRandom());
    }
}
