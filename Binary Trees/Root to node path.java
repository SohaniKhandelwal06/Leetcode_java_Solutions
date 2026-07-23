
// Root to Node Path

/*
Approach (DFS + Backtracking)

- Add the current node to the path.
- If the current node is the target, return true.
- Recursively search the left and right subtrees.
- If the target is found in either subtree, return true.
- If the target is not found, remove the current node
  from the path using backtracking.

Time Complexity: O(N)
Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/









class Solution {

    public boolean getPath(TreeNode root,
                           int target,
                           ArrayList<Integer> path) {

        if (root == null) {
            return false;
        }

        path.add(root.val);

        // Target found
        if (root.val == target) {
            return true;
        }

        // Search in left or right subtree
        if (getPath(root.left, target, path) ||
            getPath(root.right, target, path)) {

            return true;
        }

        // Backtracking
        path.remove(path.size() - 1);

        return false;
    }
}
