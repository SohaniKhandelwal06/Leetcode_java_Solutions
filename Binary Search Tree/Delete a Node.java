// Leetcode 450 - Delete Node in a BST

/*
Approach (Recursive)

Cases:

1. Node not found
   - Return null.

2. Key is smaller
   - Delete from left subtree.

3. Key is greater
   - Delete from right subtree.

4. Node found

   a) No left child
      Return right child.

   b) No right child
      Return left child.

   c) Two children
      - Find the inorder successor
        (smallest node in the right subtree).
      - Copy its value to the current node.
      - Delete the inorder successor.

Why inorder successor?
It is the next greater value in the BST,
so replacing the deleted node with it
preserves the BST property.

Time Complexity:
Average: O(log N)
Worst: O(N)

Space Complexity:
O(H)

where:
N = Number of nodes
H = Height of the tree
*/
class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        else {

            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: No right child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            TreeNode successor = findMin(root.right);

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
