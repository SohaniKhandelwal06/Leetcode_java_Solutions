// Leetcode - 141 - Linked List Cycle

/*
Approach (Floyd's Cycle Detection Algorithm / Slow and Fast Pointer):
1. Initialize two pointers: slow and fast at the head.
2. Move the slow pointer one step and the fast pointer two steps.
3. If the linked list contains a cycle, the two pointers will eventually meet.
4. If the fast pointer reaches the end of the list, no cycle exists.
5. Return true if a cycle is detected; otherwise, return false.

Time Complexity: O(N)
Space Complexity: O(1)
*/


public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
            
        }
        return false;
    }
}
