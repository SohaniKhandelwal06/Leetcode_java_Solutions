// Leetcode - 83 - Remove Duplicates from Sorted List

/*
Approach (Iterative Traversal):
1. Traverse the linked list using a pointer.
2. Compare the current node with the next node.
3. If both nodes have the same value, skip the duplicate node by updating the next pointer.
4. Otherwise, move to the next node.
5. Continue until the end of the list and return the modified head.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
if(temp.val==temp.next.val){
temp.next=temp.next.next;
}
            else{
                temp=temp.next;
            }
        }
        return head;
    }
}
            
    
