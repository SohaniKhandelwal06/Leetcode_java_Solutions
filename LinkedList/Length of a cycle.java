// Length of Cycle in a Linked List

/*
Approach (Floyd's Cycle Detection Algorithm / Slow and Fast Pointer):
1. Use slow and fast pointers to detect if a cycle exists.
2. If the pointers meet, a cycle is present.
3. Starting from the meeting point, traverse the cycle until reaching the same node again.
4. Count the number of nodes visited during this traversal.
5. Return the cycle length. If no cycle exists, return 0.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public int lengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int length = 1;
                ListNode temp = slow.next;

                while (temp != slow) {
                    length++;
                    temp = temp.next;
                }

                return length;
            }
        }

        return 0;
    }
}
