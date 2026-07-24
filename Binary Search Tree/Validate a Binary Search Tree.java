// Leetcode 98 - Validate Binary Search Tree

/*
Approach (DFS + Valid Range)

- Every node must lie within a valid range.
- Initially, a node can have any value:
      (-∞, +∞)

- For the left child:
      (-∞, root.val)

- For the right child:
      (root.val, +∞)

- Recursively validate every node using its allowed range.

Important:
Checking only the immediate children is not enough.

Time Complexity: O(N)

Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/


class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isValid(TreeNode root,long min,long max){
if(root==null) return true;
        if(root.val>=max || root.val<=min) return false;
        return isValid(root.left,min,root.val)&& isValid(root.right,root.val,max);

        
    }
}
