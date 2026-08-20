// Leetcode 1382 - Balance a Binary Search Tree
//
// Approach:
// 1. Inorder traversal of BST gives sorted values.
// 2. Pick middle element as root.
// 3. Recursively build left and right subtrees.
//
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> values = new ArrayList<>();

        inorder(root, values);

        return build(
            values,
            0,
            values.size() - 1
        );
    }

    private void inorder(
            TreeNode root,
            List<Integer> values) {

        if (root == null) {
            return;
        }

        inorder(root.left, values);

        values.add(root.val);

        inorder(root.right, values);
    }

    private TreeNode build(
            List<Integer> values,
            int left,
            int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root =
            new TreeNode(values.get(mid));

        root.left = build(
            values,
            left,
            mid - 1
        );

        root.right = build(
            values,
            mid + 1,
            right
        );

        return root;
    }
}
