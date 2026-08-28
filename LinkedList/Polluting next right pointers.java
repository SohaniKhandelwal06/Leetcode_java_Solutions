// Leetcode 116 - Populating Next Right Pointers
// in Each Node
//
// Approach: Level-by-level using existing next pointers
//
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node leftmost = root;

        while (leftmost.left != null) {

            Node curr = leftmost;

            while (curr != null) {

                // Connect left child to right child
                curr.left.next = curr.right;

                // Connect right child to
                // next node's left child
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            // Move to next level
            leftmost = leftmost.left;
        }

        return root;
    }
}
