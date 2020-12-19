package Middle;

import java.util.HashMap;
import java.util.Map;

class Solution146 {

    class DListNode {
        int key;
        int val;
        DListNode pre;
        DListNode next;
        public DListNode() {}
        public DListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, DListNode> map = new HashMap<>();
    DListNode head;
    DListNode tail;
    int capacity;
    int cur;
    public Solution146(int capacity) {
        this.capacity = capacity;
        cur = 0;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DListNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
            return node.val;
        }
    }

    public void put(int key, int value) {
        DListNode node;
        if (map.get(key) == null) {
            node = new DListNode(key, value);
            if (capacity == cur) {
                map.remove(tail.pre.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                cur--;
            }
            cur++;
        } else {
            node = map.get(key);
            node.val = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
        map.put(key, node);
    }
}