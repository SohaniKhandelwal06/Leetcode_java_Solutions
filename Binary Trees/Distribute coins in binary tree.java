//Leetcode 979 - Distribute Coins in Binary Tree

// // Approach: DFS + Postorder //
  // Each node must keep one coin for itself.
  // A subtree's balance is the total excess coins after every node
  // in that subtree has one coin. 
  // Add the absolute balance of each child to the answer because 
  // those coins must cross the edge connecting the child to its parent. 
  // Return the subtree's balance to the parent. //
  // Time Complexity: 
  // O(N) // 
  // Space Complexity: 
  // O(H)
class Solution {
    int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        moves += Math.abs(left) + Math.abs(right);

        return node.val + left + right - 1;
    }
}
