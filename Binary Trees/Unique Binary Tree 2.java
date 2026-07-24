// Leetcode 106 - Construct Binary Tree from Inorder and Postorder Traversal

/*
Approach (Recursion + HashMap)

- The last element in postorder is always the root.
- Find this root in inorder.
- Elements to the left of the root in inorder belong
  to the left subtree.
- Elements to the right belong to the right subtree.
- Construct the right subtree first because we are processing
  postorder from right to left.

Time Complexity: O(N)

Space Complexity: O(N)

where:
N = Number of nodes
*/











class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(
            inorder,
            0,
            inorder.length - 1,
            postorder,
            0,
            postorder.length - 1,
            map
        );
    }

    private TreeNode buildTree(
            int[] inorder,
            int is,
            int ie,
            int[] postorder,
            int ps,
            int pe,
            HashMap<Integer, Integer> map) {

        if (is > ie || ps > pe) {
            return null;
        }

        // Last element of postorder is the root
        TreeNode root = new TreeNode(postorder[pe]);

        int inroot = map.get(root.val);

        int numsLeft = inroot - is;

        // Build right subtree first
        root.right = buildTree(
            inorder,
            inroot + 1,
            ie,
            postorder,
            ps + numsLeft,
            pe - 1,
            map
        );

        // Build left subtree
        root.left = buildTree(
            inorder,
            is,
            inroot - 1,
            postorder,
            ps,
            ps + numsLeft - 1,
            map
        );

        return root;
    }
}
