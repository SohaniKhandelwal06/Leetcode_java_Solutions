// Leetcode 138 - Copy List with Random Pointer
//
// Approach: HashMap
//
// Map each original node to its cloned node.
//
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map =
            new HashMap<>();

        Node curr = head;

        // Create clone nodes
        while (curr != null) {

            map.put(
                curr,
                new Node(curr.val)
            );

            curr = curr.next;
        }

        // Connect next and random pointers
        curr = head;

        while (curr != null) {

            Node clone = map.get(curr);

            clone.next =
                map.get(curr.next);

            clone.random =
                map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}
