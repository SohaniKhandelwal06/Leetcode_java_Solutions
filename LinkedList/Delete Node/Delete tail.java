// Delete Tail of a Linked List

/*
Approach:
1. If the list is empty or contains only one node, return null.
2. Traverse until the second last node.
3. Make its next pointer null.
4. Return the head.

Time Complexity: O(N)
Space Complexity: O(1)
*/


class Solution {
    Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }
}
