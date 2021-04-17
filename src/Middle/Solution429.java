package Middle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node429 {
    public int val;
    public List<Node429> children;

    public Node429() {}

    public Node429(int _val) {
        val = _val;
    }

    public Node429(int _val, List<Node429> _children) {
        val = _val;
        children = _children;
    }
}

public class Solution429 {
    public List<List<Integer>> levelOrder(Node429 root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<Node429> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node429 Node429 = queue.poll();
                l.add(Node429.val);
                queue.addAll(Node429.children);
            }
            list.add(l);
        }
        return list;
    }
}
