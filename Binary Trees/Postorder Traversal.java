// Leetcode 145 - Binary Tree Postorder Traversal

/*
Traversal Order:
Left -> Right -> Root

Approach 1: Recursive

1. Traverse left subtree.
2. Traverse right subtree.
3. Visit the root.

Time Complexity: O(N)
Space Complexity: O(H)
  */







class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    private void postorder(TreeNode root, List<Integer> ans) {

        if (root == null) return;

        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}
