// Leetcode 662 - Maximum Width of Binary Tree

/*
Approach (BFS + Indexing)

- Perform level order traversal using a queue.
- Assign an index to every node as if the tree were a complete
  binary tree.

Indexing:
- Root: 0
- Left child: 2 * index + 1
- Right child: 2 * index + 2

For every level:
    width = lastIndex - firstIndex + 1

To avoid integer overflow, normalize the indices of every level
by subtracting the minimum index of that level.

Time Complexity: O(N)

Space Complexity: O(N)

where:
N = Number of nodes
*/
class Solution {


    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            int minIndex = q.peek().index;
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {

                Pair current = q.poll();

                TreeNode node = current.node;
int index = current.index - minIndex;

                if (i == 0) {
                    first = index;
                }

                if (i == size - 1) {
                    last = index;
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * index + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }


    static class Pair {

        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    }
