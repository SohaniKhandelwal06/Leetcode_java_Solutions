// Print Nodes in a Given Range in a BST

/*
Approach (DFS)

Observation:
BST Property:
- Left subtree contains smaller values.
- Right subtree contains larger values.

Algorithm:

1. If root is null, return.
2. If root.val > low,
   search the left subtree.
3. If root.val lies within [low, high],
   print it.
4. If root.val < high,
   search the right subtree.

The BST property allows us to skip
entire subtrees that cannot contain
valid values.

Time Complexity:
O(N) in the worst case.

For a balanced BST, many unnecessary
subtrees are skipped.

Space Complexity:
O(H)

where:
N = Number of nodes
H = Height of the tree
*/
class Solution {

    public void printInRange(TreeNode root, int low, int high) {

        if (root == null) return;

        if (root.val > low) {
            printInRange(root.left, low, high);
        }

        if (root.val >= low && root.val <= high) {
            System.out.print(root.val + " ");
        }

        if (root.val < high) {
            printInRange(root.right, low, high);
        }
    }
}
