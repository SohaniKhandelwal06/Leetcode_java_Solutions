//Leetcode 993 - Cousins in Binary Tree

//
// Approach: BFS
//
// Traverse the tree level by level.
// For each level, check whether x and y are present.
// They are cousins if they are at the same level but have different parents.
//
// Time Complexity:
// O(N)
//
// Space Complexity: O(N)
class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                // Check if x and y are siblings
                if (node.left != null && node.right != null) {

                    if ((node.left.val == x && node.right.val == y) ||
                        (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }

                // Check current level
                if (node.val == x) {
                    foundX = true;
                }

                if (node.val == y) {
                    foundY = true;
                }

                // Add children
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Both found at same level and not siblings
            if (foundX && foundY) {
                return true;
            }

            // Only one found at this level
            if (foundX || foundY) {
                return false;
            }
        }

        return false;
    }
}
