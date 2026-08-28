// Leetcode 117 - Populating Next Right Pointers
// in Each Node II
//
// Approach: Level-order traversal using next pointers
//
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {

    public Node connect(Node root) {

        Node curr = root;

        while (curr != null) {

            // Dummy node for the next level
            Node dummy = new Node(0);

            Node tail = dummy;

            // Traverse current level using next pointers
            while (curr != null) {

                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                curr = curr.next;
            }

            // Move to first node of next level
            curr = dummy.next;
        }

        return root;
    }
}
