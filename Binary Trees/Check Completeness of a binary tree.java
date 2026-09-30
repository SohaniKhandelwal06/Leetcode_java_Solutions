//Leetcode 958 - Check Completeness of a Binary Tree

//
// Approach: BFS
//
// Traverse the tree level by level using a queue.
// Once a null node is encountered, every node that follows in the
// BFS traversal must also be null.
// If a non-null node appears after a null node, the tree is not complete.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean foundNull = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                foundNull = true;
            } else {
                if (foundNull) return false;

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }
}
