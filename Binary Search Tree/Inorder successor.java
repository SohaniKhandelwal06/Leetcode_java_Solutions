
// Inorder Successor in a BST

/*
Approach (Using BST Property)

For a given key:

- If root.val > key:
    The current root can be a possible successor.
    Move to the left subtree to find a smaller valid successor.

- If root.val <= key:
    The successor must be in the right subtree.

The smallest value greater than the key is the inorder successor.

Time Complexity: O(H)

Space Complexity: O(1)

where:
H = Height of the BST
*/









class Solution {

    public TreeNode inorderSuccessor(TreeNode root,
                                     TreeNode p) {

        TreeNode successor = null;

        while (root != null) {

            if (root.val > p.val) {

                // Possible successor
                successor = root;

                // Try to find a smaller greater value
                root = root.left;
            } 
            else {

                // Successor must be on the right
                root = root.right;
            }
        }

        return successor;
    }
}
