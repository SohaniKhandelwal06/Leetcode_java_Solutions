//Leetcode 1080 - Insufficient Nodes in Root to Leaf Paths

//
// Approach: DFS + Postorder
//
// Traverse the tree using DFS and calculate the maximum root-to-leaf
// path sum from each node.
// If a node is a leaf and its path sum is less than limit, remove it.
// For an internal node, recursively process both children.
// After processing, if both children become null, the current node is
// also insufficient and should be removed.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(H)


class Solution {

    public TreeNode sufficientSubset(TreeNode root, int limit) {

        // If root is a leaf
        if (root.left == null && root.right == null) {
            return root.val < limit ? null : root;
        }

        // Process left subtree
        if (root.left != null) {
            root.left = sufficientSubset(
                root.left,
                limit - root.val
            );
        }

        // Process right subtree
        if (root.right != null) {
            root.right = sufficientSubset(
                root.right,
                limit - root.val
            );
        }

        // If both subtrees are removed,
        // this node is also insufficient
        if (root.left == null && root.right == null) {
            return null;
        }

        return root;
    }
}
