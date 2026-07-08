

// Leetcode - 2095 - Delete the Middle Node of a Linked List

/*
Approach (Slow and Fast Pointer):
1. Handle the edge case where the list is empty or contains only one node.
2. Initialize the slow pointer at the head and the fast pointer two nodes ahead.
3. Move the slow pointer one step and the fast pointer two steps until the fast pointer reaches the end.
4. The slow pointer will be positioned just before the middle node.
5. Delete the middle node by updating slow.next to skip the middle node.
6. Return the head of the modified linked list.

Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    public ListNode deleteMiddle(ListNode head) {
if(head==null ||head.next==null) return null; 
        ListNode slow=head;
        ListNode fast=head.next.next;
        
        while(fast!=null && fast.next!=null){
slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
    
