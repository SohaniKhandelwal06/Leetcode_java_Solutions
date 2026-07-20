// Leetcode 222 - Count Complete Tree Nodes

/*
Approach 1: DFS

1. If root is null, return 0.
2. Count:
      1 (current node)
    + left subtree
    + right subtree

Time Complexity: O(N)
Space Complexity: O(H)

----------------------------------------------------

Approach 2: Complete Binary Tree Optimization

Observation:

If the leftmost height equals the rightmost height,
then the tree is a Perfect Binary Tree.

Number of nodes in a perfect binary tree:

Nodes = 2^height - 1

Otherwise,
recursively count the left and right subtrees.

Time Complexity:
O((log N)^2)

Space Complexity:
O(log N)

where:
N = Number of nodes
H = Height of tree
*/
class Solution {
    public int countNodes(TreeNode root) {
        int left=leftHeight(root);
int right=rightHeight(root);
if(left==right){
return (1<<left)-1;
}
return 1+countNodes(root.left)+countNodes(root.right);
    }
private int leftHeight(TreeNode node){
int height=0;
    while(node!=null){
height++;
        node=node.left;
    }
return height;
}
    private int rightHeight(TreeNode node){
int height=0;
    while(node!=null){
height++;
        node=node.right;
    }
        return height;
    }
}

    
        
    
