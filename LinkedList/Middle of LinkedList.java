//876-Middle of LinkedList
/*
Approach (Slow and Fast Pointer / Tortoise and Hare Algorithm):
1. Initialize two pointers: slow and fast at the head.
2. Move the slow pointer one step and the fast pointer two steps.
3. When the fast pointer reaches the end, the slow pointer will be at the middle.
4. Return the slow pointer.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast=  head;
        ListNode slow=head;
    while(fast!=null && fast.next!=null ){
        slow=slow.next;
    fast=fast.next.next;
         }
        return slow;
    }
}
