// Leetcode 236 - Lowest Common Ancestor of a Binary Tree

/*
Approach (Postorder DFS)

- If root is null, return null.
- If root is p or q, return root.
- Recursively search for p and q in the left and right subtrees.
- If both left and right return a non-null node,
  then the current root is the LCA.
- Otherwise, return the non-null result.

Why?
If p and q are found in different subtrees of a node,
then that node is their Lowest Common Ancestor.

Time Complexity: O(N)

Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
TreeNode right=lowestCommonAncestor(root.right,p,q);
if(left!=null && right!=null) return root;
        return left!=null?left:right;
    }
         
    }
