//eetcodw 617:Merge two binary trees
/*Approach: Recursion + DFS
We are given the roots of two binary trees, root1 and root2. We need to merge them into one binary tree.

Logic:
1. If root1 is None, return root2.
2. If root2 is None, return root1.
3. If both nodes exist, add their values.
4. Recursively merge the left subtrees.
5. Recursively merge the right subtrees.
6. Return the merged root.
The key idea is to add values at overlapping nodes and reuse the existing subtree whenever one node is missing.
  */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode() {}
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        // If the first tree is empty, return the second tree
        if (root1 == null) {
            return root2;
        }

        // If the second tree is empty, return the first tree
        if (root2 == null) {
            return root1;
        }

        // Merge the values
        root1.val += root2.val;

        // Merge left subtrees
        root1.left = mergeTrees(root1.left, root2.left);

        // Merge right subtrees
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}

