// Leetcode - 160 - Intersection of Two Linked Lists

/*
Approach (Two Pointer Technique):
1. Initialize two pointers, one at the head of each linked list.
2. Move both pointers one step at a time.
3. If a pointer reaches the end of its list, redirect it to the head of the other list.
4. Continue traversing until both pointers become equal.
5. If the lists intersect, the pointers will meet at the intersection node.
6. If no intersection exists, both pointers will eventually become null.
7. Return the meeting node, which is either the intersection node or null.

Time Complexity: O(N + M)
Space Complexity: O(1)
*/

ublic class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1=headA;
        ListNode t2=headB;
        while(t1!=t2){
t1=t1.next;
            t2=t2.next;
            if(t1==t2){
                return t1;
            }
            if(t1==null) {
                t1=headB;
            }
            if(t2==null) {
                t2=headA;
            }
        }
            return t1;

        
    }
}
