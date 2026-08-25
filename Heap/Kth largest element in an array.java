// Leetcode 215 - Kth Largest Element in an Array
//
// Approach: Min Heap
//
// Keep only the k largest elements in the heap.
// The smallest among them is the kth largest.
//
// Time Complexity: O(N log K)
// Space Complexity: O(K)

class Solution {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>();

        for (int num : nums) {

            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
