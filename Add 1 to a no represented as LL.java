// Add One to a Number Represented as a Linked List

/*
Approach (Reverse Linked List):
1. Reverse the linked list to access the least significant digit first.
2. Initialize the carry as 1 to represent adding one.
3. Traverse the reversed list, updating each digit and propagating the carry.
4. If a carry remains after the last node, create a new node with the carry.
5. Reverse the linked list again to restore the original order.
6. Return the updated head.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public Node addOne(Node head) {
        head = reverse(head);

        Node temp = head;
        int carry = 1;

        while (temp != null && carry != 0) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;

            if (temp.next == null && carry != 0) {
                temp.next = new Node(carry);
                carry = 0;
            }

            temp = temp.next;
        }

        return reverse(head);
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }
}
