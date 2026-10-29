//LeetCode 1038 — Binary Search Tree to Greater Sum Tree
/*Approach
Given the root of a Binary Search Tree (BST), transform it into a Greater Sum Tree. Each node's new value is the sum of its original value plus all original values greater than it.
Key insight: Reverse inorder traversal
A normal inorder traversal of a BST visits nodes in ascending order:

Left → Root → Right

Instead, traverse in reverse inorder:

Right → Root → Left

This visits nodes from largest to smallest. Maintain a running sum of the values visited so far, and update each node with that sum.

Steps:
1. Visit the right subtree.
2. Add the current node's value to the running sum.
3. Replace the node's value with the running sum.
4. Visit the left subtree.
  */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        reverseInorder(root);
        return root;
    }

    private void reverseInorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Visit larger values first
        reverseInorder(node.right);

        // Update the running sum
        sum += node.val;
        node.val = sum;

        // Visit smaller values
        reverseInorder(node.left);
    }
}
