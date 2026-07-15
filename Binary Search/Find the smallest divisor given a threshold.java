// Leetcode - 1283 - Find the Smallest Divisor Given a Threshold

/*
Approach (Binary Search on Answer):
1. The divisor lies between 1 and the maximum element of the array.
2. Perform binary search on this range.
3. For each divisor, compute the sum of:
      ceil(nums[i] / divisor)
4. If the sum is less than or equal to the threshold,
   try a smaller divisor.
5. Otherwise, increase the divisor.
6. The first valid divisor is the answer.

Time Complexity: O(N × log(MaxElement))
Space Complexity: O(1)
*/
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possible(nums, mid, threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possible(int[] nums, int divisor, int threshold) {
        long sum = 0;

        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
        }

        return sum <= threshold;
    }
}

