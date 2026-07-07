
// Delete Head of a Linked List

/*
Approach:
1. Check if the linked list is empty.
2. If empty, return null.
3. Move the head pointer to the next node.
4. Return the updated head.

Time Complexity: O(1)
Space Complexity: O(1)
*/




class Solution {
    Node deleteHead(Node head) {
        if (head == null) {
            return null;
        }

        return head.next;
    }
}
