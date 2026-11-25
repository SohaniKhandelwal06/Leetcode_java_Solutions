//LeetCode 203 - Remove Linked List Elements

/*Approach: Dummy Node

Use a dummy node before the head to handle the case where the head itself needs to be removed.

- Create a dummy node pointing to the original head.
- Traverse the linked list using a pointer.
- If the next node contains the target value, skip that node.
- Otherwise, move the pointer forward.
- Return `dummy.next` as the updated head.
*/

/* Complexity Analysis

- **Time Complexity:** O(n), where n is the number of nodes in the linked list.
- **Space Complexity:** O(1), since only a few pointers are used.
*/


class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}





