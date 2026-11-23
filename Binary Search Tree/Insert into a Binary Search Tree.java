//LeetCode 701 – Insert into a Binary Search Tree
/*Difficulty: Medium
Topics: Tree, Binary Search Tree, Recursion
Language: Java
Approach: Recursion
In a Binary Search Tree (BST):
- Values smaller than the current node go to the left subtree.
- Values greater than the current node go to the right subtree.
- When we find a null position, create and insert the new node there.
- Return the root after insertion.
*/
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } 
        else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
