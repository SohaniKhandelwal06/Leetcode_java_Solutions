// Leetcode - 142 - Linked List Cycle II

/*
Approach (Floyd's Cycle Detection Algorithm / Slow and Fast Pointer):
1. Use slow and fast pointers to detect if a cycle exists.
2. If the pointers meet, a cycle is present.
3. Move the slow pointer back to the head while keeping the fast pointer at the meeting point.
4. Move both pointers one step at a time until they meet again.
5. The meeting point is the starting node of the cycle.
6. Return the starting node. If no cycle exists, return null.

Time Complexity: O(N)
Space Complexity: O(1)
*/


public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
slow=slow.next;
            fast=fast.next.next;
        
            if(slow==fast){
slow=head;
                while(slow!=fast){
slow=slow.next;
            fast=fast.next;
                }
            
                return slow;
            }
    }
            return null;
        }
    }
    
    
