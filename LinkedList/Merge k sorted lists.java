//Leetcode 23 - Merge k Sorted Lists

//
// Approach: Min Heap (Priority Queue)
//
// Insert the head node of every non-empty linked list into a min heap.
// The heap always gives the node with the smallest value.
// Remove the smallest node, add it to the result list, and insert
// its next node into the heap.
// Continue until the heap becomes empty.
//
// Time Complexity:
// O(N log K)
//
// Space Complexity:
// O(K)
//
// N = total number of nodes
// K = number of linked lists
import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of every list
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode node = pq.poll();

            curr.next = node;
            curr = curr.next;

            // Add next node from the same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}
