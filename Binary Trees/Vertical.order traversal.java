// Leetcode 987 - Vertical Order Traversal of a Binary Tree

/*
Approach (BFS + Coordinates)

Assign coordinates to every node:

- Root:       (row = 0, col = 0)
- Left child: (row + 1, col - 1)
- Right child:(row + 1, col + 1)

Store nodes using:

TreeMap<Column,
    TreeMap<Row,
        PriorityQueue<Values>>>

Why TreeMap?
- Columns must be processed from left to right.
- Rows must be processed from top to bottom.

Why PriorityQueue?
- If multiple nodes have the same row and column,
  they must be sorted by value.

Finally:
1. Iterate through columns in sorted order.
2. Iterate through rows in sorted order.
3. Extract values from the priority queue.

Time Complexity: O(N log N)

Space Complexity: O(N)

where:
N = Number of nodes
*/
class Solution {

    static class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair current = q.poll();

            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            map.putIfAbsent(col, new TreeMap<>());

            map.get(col)
               .putIfAbsent(row, new PriorityQueue<>());

            map.get(col)
               .get(row)
               .offer(node.val);

            if (node.left != null) {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> rows
                : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {

                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            ans.add(column);
        }

        return ans;
    }
}
