// Leetcode 99 - Recover Binary Search Tree

/*
Approach (Inorder Traversal)

- Inorder traversal of a valid BST must be sorted.
- If two nodes are swapped, the inorder sequence will contain
  one or two inversions.

Example:
    1 3 2 4

Here:
    3 > 2

The two incorrect nodes are identified during inorder traversal.

- first:  The first node involved in an inversion.
- middle: The second node involved in the first inversion.
- last:  The second node involved in the second inversion.

Cases:

1. Adjacent swapped nodes:
       1 3 2 4
         ↑ ↑

   Swap first and middle.

2. Non-adjacent swapped nodes:
       1 5 3 4 2 6
         ↑       ↑

   Swap first and last.

Finally, swap the values of the incorrect nodes.

Time Complexity: O(N)

Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/

class Solution {

    TreeNode first = null;
    TreeNode middle = null;
    TreeNode last = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {

        inorder(root);

        // Non-adjacent swapped nodes
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }

        // Adjacent swapped nodes
        else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);

        if (prev != null && prev.val > root.val) {

            if (first == null) {
                first = prev;
                middle = root;
            } 
            else {
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }
}
