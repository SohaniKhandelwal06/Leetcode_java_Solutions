// Leetcode 94 - Binary Tree Inorder Traversal

/*
Approach 1: Recursive

1. Traverse the left subtree.
2. Visit the current node.
3. Traverse the right subtree.

Traversal Order:
Left -> Root -> Right

Time Complexity: O(N)
Space Complexity: O(H)
  */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        inorder(root,ans);
return ans;
    }
    private void inorder(TreeNode root,List<Integer>ans){
        if(root==null) return ;
        inorder(root.left,ans);
        ans.add(root.val);
inorder(root.right,ans);
        
    }
}
