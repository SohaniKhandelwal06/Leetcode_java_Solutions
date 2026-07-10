// Leetcode - 81 - Search in Rotated Sorted Array II

/*
Approach (Modified Binary Search):
1. Perform binary search on the rotated sorted array.
2. If the middle element is the target, return true.
3. If the elements at low, mid, and high are equal, increment low and decrement high to remove duplicates.
4. Otherwise, determine which half of the array is sorted.
5. If the target lies within the sorted half, continue searching there; otherwise, search the other half.
6. Repeat until the target is found or the search space becomes empty.

Time Complexity: O(log N) on average, O(N) in the worst case due to duplicates.
Space Complexity: O(1)
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
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

        return false;
    }
}
