// Leetcode - 234 - Palindrome Linked List

/*
Approach (Slow and Fast Pointer + Reverse Linked List):
1. Find the middle of the linked list using the slow and fast pointer technique.
2. Reverse the second half of the linked list.
3. Compare the nodes of the first half and the reversed second half.
4. If any pair of nodes differs, return false.
5. Reverse the second half again to restore the original linked list.
6. Return true if all corresponding nodes are equal.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
if(head==null ||head.next==null){
return true;
}
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
slow=slow.next;      
            fast=fast.next.next;
        }
        ListNode secondhalf=reverse(slow.next);
ListNode first=head;
        ListNode second=secondhalf;
        while(second!=null){
if(first.val!=second.val){
    return false;
}
            first=first.next;
            second=second.next;
        }
        slow.next=reverse(secondhalf);
    
    return true;
    }
    private ListNode reverse(ListNode head){
ListNode prev=null;
        ListNode temp=head;
        while(temp!=null){
ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        
return prev;
    }
}

    
