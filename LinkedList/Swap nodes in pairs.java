//Leetcode 24 - Swap Nodes in Pairs

// // Approach: Iterative + Dummy Node //
// Use a dummy node before the head to simplify swapping the first pair. 
// For each pair, maintain prev, first, and second pointers.
// Connect the previous node to the second node, then connect the 
// second node to the first node and the first node to the next pair.
// Move prev forward and continue until fewer than two nodes remain. //
// Time Complexity: 
// O(N) //
// Space Complexity:
// O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }
}
