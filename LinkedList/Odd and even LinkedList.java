// Leetcode - 328 - Odd Even Linked List

/*
Approach:
1. If the list has fewer than two nodes, return the head.
2. Maintain two pointers: one for odd-indexed nodes and one for even-indexed nodes.
3. Keep a reference to the head of the even list.
4. Rearrange the next pointers so that all odd-indexed nodes come first, followed by all even-indexed nodes.
5. Connect the end of the odd list to the head of the even list.
6. Return the head of the modified list.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {if(head==null||head.next==null) return head;
    ListNode odd=head;
    ListNode even=head.next;
        ListNode evenhead=head.next;
        
    while(even!=null&&even.next!=null){
        odd.next=even.next;
odd=odd.next;
even.next=odd.next;
        even=even.next;
        
        
}
        odd.next=evenhead;
    
        return head;
        
    }
}
