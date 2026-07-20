// Binary Tree Preorder Traversal

/*
Traversal Order:
Root -> Left -> Right

Recursive Approach:
1. Visit the root node.
2. Traverse the left subtree.
3. Traverse the right subtree.
  Time Complexity:O(N)
  Space Complexity:O(H)
  
where:
N = Number of nodes
H = Height of the tree
*/



class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        preorder(root, ans);

        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {

        if (root == null) return;

        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
