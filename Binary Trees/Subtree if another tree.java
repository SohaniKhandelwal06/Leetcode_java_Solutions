// Leetcode 572 - Subtree of Another Tree

/*
Approach (DFS)

Observation:
A subtree must match both:
1. Structure
2. Node values

Algorithm:

1. Traverse every node of the main tree.
2. At each node, check whether the subtree rooted
   at that node is identical to subRoot.
3. If identical, return true.
4. Otherwise, recursively search in the left
   and right subtrees.

isSameTree():
- If both nodes are null → true.
- If one is null → false.
- If values differ → false.
- Otherwise, recursively compare the left and
  right subtrees.

Time Complexity:
O(N × M)

where:
N = Number of nodes in root
M = Number of nodes in subRoot

Space Complexity:
O(H)

where:
H = Height of the tree
*/

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(subRoot==null) return true;
        if(root.val==subRoot.val){
            if(isIdentical(root,subRoot))
            {
                return true;
            }
        }
            return isSubtree(root.left,subRoot)|| isSubtree(root.right,subRoot);
        }
private boolean isIdentical(TreeNode p,TreeNode q){
if(p==null && q==null) return true;
    if(p==null || q==null) return false;
if(p.val!=q.val) return false;
    return isIdentical(p.left,q.left)&& isIdentical(p.right,q.right);
    
        
    }
}
