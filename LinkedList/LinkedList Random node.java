//Leetcode 382 - Linked List Random Node

//
// Approach: Reservoir Sampling
//
// Traverse the linked list once.
// For the i-th node, replace the selected node with probability 1/i.
// This ensures every node has an equal probability of being selected.
//
// Time Complexity:
// getRandom() -> O(N)
//
// Space Complexity: O(1)

class Solution {

    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {

        int result = head.val;
        ListNode current = head.next;

        int count = 2;

        while (current != null) {

            // Select current node with probability 1/count
            if (random.nextInt(count) == 0) {
                result = current.val;
            }

            current = current.next;
            count++;
        }

        return result;
    }
}
