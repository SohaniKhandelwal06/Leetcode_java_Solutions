// Leetcode 235 - Lowest Common Ancestor of a BST

/*
Approach (Using BST Property)

Observation:
In a BST:
- Left subtree contains smaller values.
- Right subtree contains larger values.

Algorithm:

1. Start from the root.
2. If both p and q are smaller than root,
   move to the left subtree.
3. If both p and q are greater than root,
   move to the right subtree.
4. Otherwise,
   the current node is the Lowest Common Ancestor.

Why?
The first node where p and q split into different
subtrees (or one of them is the current node)
is their LCA.

Time Complexity:
Average: O(log N)
Worst: O(N)

Space Complexity:
Iterative: O(1)
Recursive: O(H)

where:
N = Number of nodes
H = Height of the tree
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
if(p.val<root.val && q.val<root.val){
root=root.left;
}
            else if(p.val>root.val && q.val>root.val){
root=root.right;
            }
else{
    return root;
}
        }
        return null;
            
}
        
    }
