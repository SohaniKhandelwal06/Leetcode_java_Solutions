// Insert at Tail of a Linked List

/*
Approach:
1. Create a new node with the given value.
2. If the list is empty, return the new node.
3. Traverse to the last node.
4. Link the last node to the new node.
5. Return the head.

Time Complexity: O(N)
Space Complexity: O(1)
*/





class Solution {
    Node insertTail(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }
}
