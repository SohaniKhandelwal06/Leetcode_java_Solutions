// Leetcode 543 - Diameter of Binary Tree

/*
Approach (Brute Force)

Observation:
The diameter of a binary tree is the maximum number
of edges between any two nodes.

For every node:
1. Find the diameter of the left subtree.
2. Find the diameter of the right subtree.
3. Find the longest path passing through the current node:
      height(left subtree) + height(right subtree)
4. Return the maximum among these three values.

The height of a subtree is computed recursively.

Time Complexity:
- O(N²) in the worst case (skewed tree)
- O(N log N) for a balanced tree

Reason:
For every node, the height of its left and right
subtrees is calculated again, leading to repeated work.

Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/





class Solution {
    private int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
return Math.max(left,right)+1;
        
    }
 public int diameterOfBinaryTree(TreeNode root) {
if(root==null) return 0;
     int diam1=diameterOfBinaryTree(root.left);
int diam2=diameterOfBinaryTree(root.right);
     int diam3=maxDepth(root.left)+maxDepth(root.right);
return Math.max(diam1,(Math.max(diam2,diam3)));
        
    }
}
