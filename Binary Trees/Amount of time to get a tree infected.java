
// Leetcode 2385 - Amount of Time for Binary Tree to Be Infected

/*
Approach (Parent Mapping + BFS)

- The infection can spread to the left child,
  right child, and parent.
- Since TreeNode does not have a parent pointer,
  first create a parent mapping.
- Find the node containing the start value.
- Start BFS from the infected node.
- Each BFS level represents one minute.
- Continue until all reachable nodes are infected.

Time Complexity: O(N)

Space Complexity: O(N)

where:
N = Number of nodes
*/





class Solution {

    public int amountOfTime(TreeNode root, int start) {

        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

        TreeNode startNode =
            buildParentMap(root, start, parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.offer(startNode);
        visited.add(startNode);

        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            boolean infected = false;

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left child
                if (node.left != null &&
                    !visited.contains(node.left)) {

                    visited.add(node.left);
                    q.offer(node.left);
                    infected = true;
                }

                // Right child
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    q.offer(node.right);
                    infected = true;
                }

                // Parent
                TreeNode parent = parentMap.get(node);

                if (parent != null &&
                    !visited.contains(parent)) {

                    visited.add(parent);
                    q.offer(parent);
                    infected = true;
                }
            }

            if (infected) {
                time++;
            }
        }

        return time;
    }

    private TreeNode buildParentMap(
            TreeNode root,
            int start,
            HashMap<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        TreeNode startNode = null;

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node.val == start) {
                startNode = node;
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }

        return startNode;
    }
}
