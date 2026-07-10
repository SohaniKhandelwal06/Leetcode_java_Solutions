// Leetcode - 153 - Find Minimum in Rotated Sorted Array

/*
Approach (Modified Binary Search):
1. Initialize low and high pointers.
2. If the current search space is already sorted, the leftmost element is the minimum.
3. Otherwise, determine which half is sorted.
4. If the left half is sorted:
   - Update the minimum with nums[low].
   - Search in the right half.
5. Otherwise:
   - Update the minimum with nums[mid].
   - Search in the left half.
6. Continue until the search space is exhausted.
7. Return the minimum element found.

Time Complexity: O(log N)
Space Complexity: O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {

            // Left half is sorted
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }

            int mid = low + (high - low) / 2;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }
            // Right half is sorted
            else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }
}
