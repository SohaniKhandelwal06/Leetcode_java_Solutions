
// Leetcode 669 - Trim a Binary Search Tree

/*
Approach (Recursion)

- If root is null, return null.
- If root value is smaller than low,
  discard the left subtree and recurse on the right.
- If root value is greater than high,
  discard the right subtree and recurse on the left.
- Otherwise:
    - Trim the left subtree.
    - Trim the right subtree.
    - Return the current root.

Since it is a BST, entire subtrees can be discarded
without checking every node.

Time Complexity: O(N)

Space Complexity: O(H)
  */


class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        if(root.val<low){
return trimBST(root.right,low,high);
        }
if(root.val>high){
return trimBST(root.left,low,high);
}
root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
    return root;
    }
}
    
