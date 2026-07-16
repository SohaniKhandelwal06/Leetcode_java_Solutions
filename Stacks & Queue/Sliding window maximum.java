// Leetcode - 239 - Sliding Window Maximum

/*
Approach (Monotonic Decreasing Deque):
1. Maintain a deque storing indices of elements.
2. Remove indices from the front that are outside the current window.
3. Remove indices from the back whose values are smaller than or
   equal to the current element.
4. Add the current index to the back of the deque.
5. Once the first window is formed (i >= k - 1),
   the front of the deque stores the index of the maximum element.
6. Store nums[dq.peekFirst()] as the answer.

Why store indices?
- To efficiently check whether an element is outside the current window.

Time Complexity: O(N)
Space Complexity: O(K)
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // Remove indices that are out of the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Store the maximum for the current window
            if (i >= k - 1) {
                ans[idx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}
