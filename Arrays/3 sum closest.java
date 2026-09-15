//Leetcode 16 - 3Sum Closest

//
// Approach: Sorting + Two Pointer
//
// Sort the array first. Fix one element and use two pointers
// for the remaining two elements.
// If the current sum is closer to the target, update the answer.
// Move left when sum is smaller than target, otherwise move right.
//
// Time Complexity: O(N²)
//
// Space Complexity: O(1)

class Solution {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // Update closest sum
                if (Math.abs(sum - target) <
                    Math.abs(closest - target)) {

                    closest = sum;
                }

                // Exact target found
                if (sum == target) {
                    return sum;
                }

                // Need a larger sum
                if (sum < target) {
                    left++;
                }

                // Need a smaller sum
                else {
                    right--;
                }
            }
        }

        return closest;
    }
}
