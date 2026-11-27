//LeetCode 865 - Smallest Subtree with all the Deepest Nodes

/*Approach: Depth-First Search (DFS)

Use recursion to find the depth of the deepest node in each subtree.

For every node:

Recursively calculate the depth of its left subtree.

Recursively calculate the depth of its right subtree.

If both depths are equal, the current node is the smallest subtree root containing all deepest nodes.

If the left depth is greater, return the result from the left subtree.

If the right depth is greater, return the result from the right subtree.

The recursive function returns both the candidate subtree root and the depth.
Complexity Analysis

Let m be the number of rows and n be the number of columns.

Time Complexity: O(m × n × 4^L), where L is the maximum number of cells in a path. Each non-zero cell can be a starting point, and DFS explores possible directions.

Space Complexity: O(L), due to the recursive DFS call stack.
*/

class Solution {

    private class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {

        if (root == null) {
            return new Result(null, 0);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth == right.depth) {
            return new Result(root, left.depth + 1);
        }

        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        }

        return new Result(right.node, right.depth + 1);
    }
}
