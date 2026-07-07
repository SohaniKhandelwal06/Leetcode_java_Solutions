// Insert at Kth Position of a Linked List

/*
Approach:
1. Create a new node with the given value.
2. If k is 1, insert the node at the head.
3. Traverse to the (k-1)th node.
4. Link the new node to the kth node.
5. Update the (k-1)th node to point to the new node.
6. Return the head.

Time Complexity: O(N)
Space Complexity: O(1)
*/







class Solution {
    Node insertKth(Node head, int val, int k) {
        Node newNode = new Node(val);

        if (k == 1) {
            newNode.next = head;
            return newNode;
        }

        Node temp = head;

        for (int i = 1; temp != null && i < k - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
}
