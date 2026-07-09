// Leetcode - 61 - Rotate List

/*
Approach (Circular Linked List):
1. Handle edge cases where the list is empty, has one node, or k is 0.
2. Traverse the list to find its length and the last node.
3. Compute k % length to avoid unnecessary rotations.
4. Connect the last node to the head to form a circular linked list.
5. Move (length - k) steps to find the new tail.
6. The next node of the new tail becomes the new head.
7. Break the circular link and return the new head.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null || k==0){
            return head;
        }
        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
            tail=tail.next;
            len++;
        }
        k=k%len;
        if(k==0){
            return head;
        }
        tail.next=head;
        int steps=len-k;
        ListNode newTail=tail;
        while(steps-->0){
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
        }
        }
        
    
