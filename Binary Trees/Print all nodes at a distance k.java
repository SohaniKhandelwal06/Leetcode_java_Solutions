// Leetcode 863 - All Nodes Distance K in Binary Tree

/*
Approach (Parent Mapping + BFS)

A binary tree only has references from parent to children.
To move in all directions from the target, we need:

    1. Left child
    2. Right child
    3. Parent

So first create a mapping:

    child -> parent

Then perform BFS starting from the target.

At every step, we move to:
- left child
- right child
- parent

We keep track of visited nodes to avoid visiting the same node
again.

When the BFS reaches distance k, all nodes in the queue are
the required answer.

Time Complexity: O(N)

Space Complexity: O(N)

where:
N = Number of nodes
*/
class Solution {

    public List<Integer> distanceK(TreeNode root,
                                   TreeNode target,
                                   int k) {

        List<Integer> ans = new ArrayList<>();

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        // Step 1: Create parent mapping
        buildParentMap(root, parentMap);

        // Step 2: BFS from target
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            if (distance == k) {
                while (!q.isEmpty()) {
                    ans.add(q.poll().val);
                }

                return ans;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left child
                if (node.left != null &&
                    !visited.contains(node.left)) {

                    visited.add(node.left);
                    q.offer(node.left);
                }

                // Right child
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    q.offer(node.right);
                }

                // Parent
                TreeNode parent = parentMap.get(node);

                if (parent != null &&
                    !visited.contains(parent)) {

                    visited.add(parent);
                    q.offer(parent);
                }
            }

            distance++;
        }

        return ans;
    }

    private void buildParentMap(TreeNode root,
                                Map<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }
    }
}
