//Leetcode 724 - Find Pivot Index

//
// Approach: Prefix Sum
//
// Calculate the total sum of the array.
// Maintain leftSum while traversing the array.
// For every index, calculate rightSum = totalSum - leftSum - nums[i].
// If leftSum == rightSum, return that index.
//
// Time Complexity:
// O(N)
//
// Space Complexity: O(1)





class Solution {

    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Check every index
        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
