// Boundary Traversal of Binary Tree

/*
Approach:

Boundary traversal consists of:

1. Root
2. Left Boundary
3. All Leaf Nodes
4. Right Boundary in Reverse Order

Important:
- Leaf nodes are not included in the left and right boundaries
  to avoid duplicates.
- The right boundary is collected from top to bottom and then
  reversed to get anti-clockwise traversal.

Algorithm:

1. Add the root if it is not a leaf.
2. Traverse the left boundary:
   - Prefer the left child.
   - If left child is unavailable, move to the right child.
3. Traverse all leaf nodes using DFS.
4. Traverse the right boundary:
   - Prefer the right child.
   - If right child is unavailable, move to the left child.
5. Reverse the right boundary and add it to the answer.

Time Complexity: O(N)
Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/
class Solution {

    public ArrayList<Integer> boundaryTraversal(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        // Root
        if (!isLeaf(root)) {
            ans.add(root.val);
        }

        // Left Boundary
        addLeftBoundary(root, ans);

        // Leaf Nodes
        addLeaves(root, ans);

        // Right Boundary
        ArrayList<Integer> rightBoundary = new ArrayList<>();
        addRightBoundary(root, rightBoundary);

        Collections.reverse(rightBoundary);
        ans.addAll(rightBoundary);

        return ans;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void addLeftBoundary(TreeNode root,
                                 ArrayList<Integer> ans) {

        TreeNode curr = root.left;

        while (curr != null) {

            if (!isLeaf(curr)) {
                ans.add(curr.val);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeaves(TreeNode root,
                           ArrayList<Integer> ans) {

        if (root == null) return;

        if (isLeaf(root)) {
            ans.add(root.val);
            return;
        }

        addLeaves(root.left);
        addLeaves(root.right);
    }

    private void addRightBoundary(TreeNode root,
                                   ArrayList<Integer> ans) {

        TreeNode curr = root.right;

        while (curr != null) {

            if (!isLeaf(curr)) {
                ans.add(curr.val);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }
}
