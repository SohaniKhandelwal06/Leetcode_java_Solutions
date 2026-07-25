//Leetcode 114 - Flatten Binary Tree to Linked List

/*
Approach (Morris-style Traversal)

- Traverse the tree using a pointer curr.
- If the current node has no left subtree,
  simply move to the right.
- If a left subtree exists:
    1. Find the rightmost node of the left subtree.
    2. Connect it to the original right subtree.
    3. Move the left subtree to the right.
    4. Set the left pointer to null.
- Continue moving through the right pointers.

This produces the preorder traversal:

    Root → Left → Right

Time Complexity: O(N)

Space Complexity: O(1)
*/








class Solution {
    
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
if(curr.left!=null) {
    TreeNode prev=curr.left;
                    
            while(prev.right!=null){
prev=prev.right;
            }

            prev.right=curr.right;
            curr.right=curr.left;
            curr.left=null;
        
        }
        curr=curr.right;
    }
    }
}
        
    
