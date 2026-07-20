// Sum of Nodes in a Binary Tree (Iterative)

/*
Approach (Level Order Traversal / BFS)

1. If the tree is empty, return 0.
2. Create a queue and insert the root node.
3. Initialize sum = 0.
4. While the queue is not empty:
   - Remove the front node.
   - Add its value to sum.
   - Insert its left child if it exists.
   - Insert its right child if it exists.
5. Return the total sum.

Why Queue?
A queue helps traverse the tree level by level (Breadth-First Search),
ensuring every node is visited exactly once.

Time Complexity: O(N)
Space Complexity: O(N)

where:
N = Number of nodes.
*/






class Solution {

    public int sumOfNodes(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int sum = 0;

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            sum += node.val;

            if (node.left != null) {
                q.offer(node.left);
            }

            if (node.right != null) {
                q.offer(node.right);
            }
        }

        return sum;
    }
}
