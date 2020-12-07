package Middle;

import java.util.HashMap;
import java.util.Map;

class Solution138 {
    Map<NodeR, NodeR> map = new HashMap<>();
    public NodeR copyRandomList(NodeR head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        NodeR newNodeR = new NodeR(head.val);
        map.put(head, newNodeR);
        newNodeR.next = copyRandomList(head.next);
        newNodeR.random = copyRandomList(head.random);
        return newNodeR;
    }
}