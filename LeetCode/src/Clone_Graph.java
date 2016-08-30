import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 * 133. Clone Graph
 * @author lorreina
 *
 */
public class Clone_Graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        Queue<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode> ();
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode> ();
        
        queue.offer(node);
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node.label, nodeCopy);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            UndirectedGraphNode copy = map.get(curr.label);
            List<UndirectedGraphNode> neighbors = copy.neighbors;
            for (int i = 0; i < curr.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = curr.neighbors.get(i);
                if (!map.containsKey(neighbor.label)) {
                    queue.add(neighbor);
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighborCopy.label, neighborCopy);
                    neighbors.add(neighborCopy);
                } else {
                    neighbors.add(map.get(neighbor.label));
                }
            }
        }
        
        return nodeCopy;
    }
    
    
    class UndirectedGraphNode {
    	int label;
    	List<UndirectedGraphNode> neighbors;
    	UndirectedGraphNode(int x) { 
    		label = x; 
    		neighbors = new ArrayList<UndirectedGraphNode>(); 
    	}
    }
    
    /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     *     int label;
     *     List<UndirectedGraphNode> neighbors;
     *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     * };
     */
}
