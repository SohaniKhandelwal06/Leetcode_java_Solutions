// Right View of Binary Tree

/*
Approach (BFS + Level Order Traversal)

- Perform level order traversal using BFS.
- For every level, the last node encountered is visible
  from the right side.
- Add the last node of every level to the answer.

Time Complexity: O(N)
Space Complexity: O(N)

where:
N = Number of nodes
*/

class Solution {

    public ArrayList<Integer> rightView(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Last node of every level
                if (i == size - 1) {
                    ans.add(node.val);
                }

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return ans;
    }
}
