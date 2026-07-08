// Leetcode - 21 - Merge Two Sorted Lists

/*
Approach (Two Pointer Technique):
1. Create a dummy node to simplify the merging process.
2. Initialize a pointer to build the merged linked list.
3. Compare the current nodes of both lists and attach the smaller node to the merged list.
4. Move the pointer of the list from which the node was taken.
5. Repeat until one of the lists is exhausted.
6. Attach the remaining nodes of the non-empty list to the merged list.
7. Return the merged list starting from dummy.next.

Time Complexity: O(N + M)
Space Complexity: O(1)
*/


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1=list1;
        ListNode t2=list2;
ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(t1!=null && t2!=null){
            
if(t1.val<t2.val){
    temp.next=t1;
    temp=t1;
    t1=t1.next;
}
            else{
                temp.next=t2;
                temp=t2;
                t2=t2.next;
            }
        }
        
        if(t1!=null) {
            temp.next=t1;
        }
if(t2!=null){
    temp.next=t2;
        
            }
        
        return dummy.next;
        
    }
}
