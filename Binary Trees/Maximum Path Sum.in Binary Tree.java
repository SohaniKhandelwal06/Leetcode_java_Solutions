// Leetcode 124 - Binary Tree Maximum Path Sum

/*
Approach (DFS + Postorder Traversal)

- For every node, calculate the maximum path sum
  that can be extended to its parent.
- A negative subtree contribution is ignored by
  taking max(0, gain).
- The maximum path passing through the current node is:
      root.val + leftGain + rightGain
- Update the global maximum with this value.
- When returning to the parent, only one side can be
  selected because a path cannot branch.

Return Value:
root.val + max(leftGain, rightGain)

Time Complexity: O(N)
Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/
class Solution {
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
return maxsum;
    }
    private int maxPath(TreeNode root){
if(root==null) return 0;
        int left=Math.max(0,maxPath(root.left));
int right=Math.max(0,maxPath(root.right));
        maxsum=Math.max(maxsum,root.val+left+right);
return root.val+Math.max(left,right);
    }
}
        
    

