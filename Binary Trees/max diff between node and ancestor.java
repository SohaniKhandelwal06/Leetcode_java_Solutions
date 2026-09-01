// Leetcode 1026 - Maximum Difference Between Node and Ancestor
//
// Approach: DFS
//
// For each node, maintain the minimum and maximum
// values seen on the path from the root.
//
// Answer = maximum difference between them.
//
// Time Complexity: O(N)
// Space Complexity: O(H)
// H = height of the tree

class Solution {

    public int maxAncestorDiff(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return dfs(
            root,
            root.val,
            root.val
        );
    }

    private int dfs(
            TreeNode node,
            int minValue,
            int maxValue) {

        if (node == null) {
            return maxValue - minValue;
        }

        minValue =
            Math.min(minValue, node.val);

        maxValue =
            Math.max(maxValue, node.val);

        int left =
            dfs(
                node.left,
                minValue,
                maxValue
            );

        int right =
            dfs(
                node.right,
                minValue,
                maxValue
            );

        return Math.max(left, right);
    }
}
