// Leetcode - 33 - Search in Rotated Sorted Array

/*
Approach (Modified Binary Search):
1. Perform binary search on the rotated sorted array.
2. At each step, determine which half of the array is sorted.
3. If the left half is sorted:
   - Check whether the target lies within the left half.
   - If yes, search the left half; otherwise, search the right half.
4. If the right half is sorted:
   - Check whether the target lies within the right half.
   - If yes, search the right half; otherwise, search the left half.
5. Repeat until the target is found or the search space becomes empty.

Time Complexity: O(log N)
Space Complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
