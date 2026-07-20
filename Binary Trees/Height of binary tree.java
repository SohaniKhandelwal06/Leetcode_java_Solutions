// Leetcode 104 - Maximum Depth of Binary Tree



/*
Approach (Recursive DFS)

1. If the current node is null,
   return 0.
2. Recursively compute the height of the left subtree.
3. Recursively compute the height of the right subtree.
4. Return:
      1 + max(leftHeight, rightHeight)

The '+1' accounts for the current node.

Time Complexity: O(N)
Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
return Math.max(left,right)+1;
        
    }
}
