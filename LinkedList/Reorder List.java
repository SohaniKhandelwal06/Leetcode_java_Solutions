// LeetCode 143 — Reorder List
/* Approach: 
Find Middle + Reverse + Merge
Given a singly linked list, reorder it in the pattern:

We must rearrange the existing nodes without changing their values or creating a new list.

Steps:
1. Find the middle of the linked list using slow and fast pointers.
2. Split the list into two halves.
3. Reverse the second half.
4. Merge the two halves alternately, taking one node from each.
  */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split the list into two halves
        ListNode second = slow.next;
        slow.next = null;

        // Step 3: Reverse the second half
        ListNode prev = null;
        ListNode curr = second;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 4: Merge both halves alternately
        ListNode first = head;
        second = prev;

        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}
