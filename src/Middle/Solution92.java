package Middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode flag = dummy;
        ListNode p = head;
        int step = 0;
        while (++step < m) {
            flag = p;
            p = p.next;
        }
        for (int i = m; i < n; i++) {
            ListNode rnode = p.next;
            p.next = p.next.next;
            rnode.next = flag.next;
            flag.next = rnode;
        }
        return dummy.next;
    }
}