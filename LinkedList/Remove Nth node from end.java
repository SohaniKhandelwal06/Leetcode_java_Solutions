// Leetcode - 19 - Remove Nth Node From End of List

/*
Approach (Two Pointer Technique):
1. Create a dummy node pointing to the head to handle edge cases.
2. Initialize two pointers, slow and fast, at the dummy node.
3. Move the fast pointer (n + 1) steps ahead to maintain a gap of n nodes.
4. Move both pointers one step at a time until the fast pointer reaches the end.
5. The slow pointer will be just before the node to be removed.
6. Delete the target node by updating slow.next.
7. Return dummy.next as the new head.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
            while(fast!=null){
slow=slow.next;
                fast=fast.next;
        }
            slow.next=slow.next.next;
        
    
        return dummy.next;
    }
}

