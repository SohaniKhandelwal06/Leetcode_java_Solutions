//Leetcode 133-Clone Graph
/* Approach: DFS + HashMap
We are given a reference to a node in a connected, undirected graph. We need to create a deep copy of the graph.

Each node contains:
- val — the node's value.
- neighbors — a list of its neighboring nodes.
Steps:
1. If the input node is null, return null.
2. Use a HashMap to map each original node to its cloned node.
3. If a node has already been cloned, return its clone.
4. Otherwise, create a new node and store it in the map.
5. Recursively clone every neighbor and add the cloned neighbor to the new node.
6. Return the cloned starting node.
  */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
*/

import java.util.*;

class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Return the clone if this node was already visited
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create and store the cloned node
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
