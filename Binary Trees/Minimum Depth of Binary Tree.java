//Leetcode 111 - Minimum Depth of Binary Tree

//
// Approach: BFS
//
// Traverse the tree level by level.
// The first leaf node encountered is the node with the minimum depth.
// BFS avoids traversing deeper levels once the nearest leaf is found.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
class Solution {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                // First leaf found = minimum depth
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++;
        }

        return depth;
    }
}
