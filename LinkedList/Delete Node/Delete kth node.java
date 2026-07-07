// Delete Kth Node of a Linked List

/*
Approach:
1. If the list is empty, return null.
2. If k is 1, delete the head node.
3. Traverse to the (k-1)th node.
4. Update its next pointer to skip the kth node.
5. Return the head.

Time Complexity: O(N)
Space Complexity: O(1)
*/






class Solution {
    Node deleteKthNode(Node head, int k) {
        if (head == null) {
            return null;
        }

        if (k == 1) {
            return head.next;
        }

        Node temp = head;

        for (int i = 1; temp != null && i < k - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            return head;
        }

        temp.next = temp.next.next;

        return head;
    }
}
