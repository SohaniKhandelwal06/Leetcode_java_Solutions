// Leetcode - 206 - Reverse Linked List

/*
Approach:
1. Initialize two pointers: prev as null and curr as the head.
2. Traverse the linked list until curr becomes null.
3. Store the next node before changing the link.
4. Reverse the current node's next pointer to point to the previous node.
5. Move both pointers one step forward.
6. Return prev as the new head of the reversed linked list.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode front=temp.next;
           temp.next=prev;
            prev=temp;
            temp=front;
            
        }
        return prev;
    }
}
