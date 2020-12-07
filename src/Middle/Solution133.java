package Middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution133 {
    Map<NodeG, NodeG> visited = new HashMap<>();
    public NodeG cloneGraph(NodeG NodeG) {
        if (NodeG == null) {
            return null;
        }
        if (visited.containsKey(NodeG)) {
            return visited.get(NodeG);
        }
        NodeG newNodeG = new NodeG(NodeG.val);
        visited.put(NodeG, newNodeG);
        for (NodeG sNodeG : NodeG.neighbors) {
            newNodeG.neighbors.add(cloneGraph(sNodeG));
        }
        return newNodeG;
    }
}