// Leetcode 110 - Balanced Binary Tree

/*
Approach (Bottom-Up DFS)

Observation:
A binary tree is balanced if, for every node,
the difference between the heights of the left
and right subtrees is at most 1.

Algorithm:

1. Compute the height of the left subtree.
2. Compute the height of the right subtree.
3. If either subtree is already unbalanced,
   return -1.
4. If |leftHeight - rightHeight| > 1,
   return -1.
5. Otherwise, return:
      1 + max(leftHeight, rightHeight)

The main function checks:
height(root) != -1

Why return -1?
It acts as a flag indicating that an unbalanced
subtree has been found, allowing us to stop
further unnecessary calculations.

Time Complexity: O(N)
Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }
private int height(TreeNode root){
    if(root==null) return 0;
    int lh=height(root.left);
    int rh=height(root.right);
    if(lh==-1 || rh==-1) return -1;
    if(Math.abs(lh-rh)>1) return -1;
    return 1+Math.max(lh,rh);
}
}
    

        
    
