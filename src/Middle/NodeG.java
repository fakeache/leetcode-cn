package Middle;

import java.util.ArrayList;
import java.util.List;

class NodeG {
    public int val;
    public List<NodeG> neighbors;
    public NodeG() {
        val = 0;
        neighbors = new ArrayList<NodeG>();
    }
    public NodeG(int _val) {
        val = _val;
        neighbors = new ArrayList<NodeG>();
    }
    public NodeG(int _val, ArrayList<NodeG> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
