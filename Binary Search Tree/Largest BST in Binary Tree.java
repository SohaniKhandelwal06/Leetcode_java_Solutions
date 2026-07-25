// Largest BST in a Binary Tree

/*
Approach (Postorder DFS)

For every subtree, return four pieces of information:

1. Whether the subtree is a BST.
2. Minimum value in the subtree.
3. Maximum value in the subtree.
4. Size of the subtree.

A subtree is a BST if:

    left subtree is BST
    right subtree is BST
    left maximum < root.val
    root.val < right minimum

If the current subtree is a valid BST:
    size = left.size + right.size + 1

Otherwise:
    it is not a BST.

Update the global maximum whenever a valid BST is found.

Time Complexity: O(N)

Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/

class Solution {

    int maxBST = 0;

    static class Info {

        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST,
             int size,
             int min,
             int max) {

            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBST(TreeNode root) {

        dfs(root);

        return maxBST;
    }

    private Info dfs(TreeNode root) {

        // Empty subtree is a valid BST
        if (root == null) {
            return new Info(
                true,
                0,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE
            );
        }

        Info left = dfs(root.left);
        Info right = dfs(root.right);

        // Check whether current subtree is a BST
        if (left.isBST &&
            right.isBST &&
            left.max < root.val &&
            root.val < right.min) {

            int size = left.size + right.size + 1;

            maxBST = Math.max(maxBST, size);

            int minValue = Math.min(root.val, left.min);
            int maxValue = Math.max(root.val, right.max);

            return new Info(
                true,
                size,
                minValue,
                maxValue
            );
        }

        // Current subtree is not a BST
        return new Info(
            false,
            0,
            0,
            0
        );
    }
}
