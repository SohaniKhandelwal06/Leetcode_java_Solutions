// Top View of Binary Tree

/*
Approach (BFS + Horizontal Distance)

- Perform level order traversal using BFS.
- Assign horizontal distance (hd) to every node:
      Root       -> 0
      Left child -> hd - 1
      Right child-> hd + 1

- For every horizontal distance, store only the first
  node encountered.

Why BFS?
BFS visits nodes level by level, so the first node found
at a particular horizontal distance is the topmost node.

- Use TreeMap to automatically store horizontal distances
  from left to right.

Time Complexity: O(N log N)
Space Complexity: O(N)

where:
N = Number of nodes
*/

class Solution {

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> topView(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair current = q.poll();

            TreeNode node = current.node;
            int hd = current.hd;

            // Store only the first node at this horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            if (node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
            }
        }

        ans.addAll(map.values());

        return ans;
    }
}
