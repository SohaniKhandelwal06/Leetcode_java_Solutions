// Leetcode 700 - Search in a Binary Search Tree

/*
Approach (Iterative)

Observation:
A Binary Search Tree (BST) satisfies:
- Left subtree contains smaller values.
- Right subtree contains larger values.

Algorithm:

1. Start from the root.
2. If root is null, return null.
3. If root.val == val, return the node.
4. If val < root.val,
   move to the left child.
5. Otherwise,
   move to the right child.
6. Repeat until the node is found or
   the tree becomes empty.

Time Complexity:
- Average: O(log N)
- Worst: O(N)

Space Complexity: O(1)

where:
N = Number of nodes
*/
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null){
if(root.val==val) {
return root;
}
            else if(root.val<val){
root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return null;
    }
}
            
        
    
