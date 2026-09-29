Leetcode 590 - N-ary Tree Postorder Traversal

//
// Approach: DFS Recursion
//
// Traverse all children of the current node first.
// After visiting every child, add the current node's value to the result.
// This follows the postorder traversal pattern: children → root.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(H)
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        dfs(root, result);

        return result;
    }

    private void dfs(Node node, List<Integer> result) {
        if (node == null) return;

        for (Node child : node.children) {
            dfs(child, result);
        }

        result.add(node.val);
    }
}
