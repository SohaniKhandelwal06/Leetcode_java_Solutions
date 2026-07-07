// Leetcode - 2 - Add Two Numbers

/*
Approach:
1. Create a dummy node to simplify the construction of the result list.
2. Traverse both linked lists simultaneously while maintaining a carry.
3. Add the corresponding digits along with the carry.
4. Create a new node with the digit (sum % 10) and update the carry (sum / 10).
5. Continue until both lists are fully traversed and no carry remains.
6. Return the node next to the dummy node as the head of the result list.

Time Complexity: O(max(N, M))
Space Complexity: O(max(N, M))
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int carry=0;
        while(l1!=null ||l2!=null ||carry!=0){
            int sum=carry;
            if(l1!=null){
 sum=sum+l1.val;
                l1=l1.next;
            }
            if(l2!=null){
sum=sum+l2.val;
                l2=l2.next;
        }
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
        }
        return dummy.next;
        
    }
}
