// Insert at Head of a Linked List

/*
Approach:
1. Create a new node with the given value.
2. Point the new node to the current head.
3. Update the head to the new node.
4. Return the updated head.

Time Complexity: O(1)
Space Complexity: O(1)
*/






class Solution {
    Node insertHead(Node head, int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        return newNode;
    }
}
