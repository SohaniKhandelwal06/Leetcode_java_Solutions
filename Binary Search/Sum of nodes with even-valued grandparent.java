//Leetcode 1315 - Sum of Nodes with Even-Valued Grandparent

//
// Approach: DFS
//
// Traverse the binary tree while keeping track of the parent and
// grandparent values.
// If the grandparent exists and has an even value, add the current
// node's value to the answer.
// Recursively process both left and right subtrees.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(H)
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }

    private int dfs(TreeNode node, TreeNode parent, TreeNode grandparent) {
        if (node == null) {
            return 0;
        }

        int sum = 0;

        if (grandparent != null && grandparent.val % 2 == 0) {
            sum += node.val;
        }

        sum += dfs(node.left, node, parent);
        sum += dfs(node.right, node, parent);

        return sum;
    }
}
