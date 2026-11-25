//LeetCode 674 - Longest Continuous Increasing Subsequence

/*Approach: Greedy

Traverse the array and maintain the length of the current strictly increasing contiguous sequence.

Initialize current and maxLength to 1.

If the current element is greater than the previous element, increment current.

Otherwise, reset current to 1.

Update maxLength whenever a longer sequence is found.

Return maxLength.
Complexity Analysis

Time Complexity: O(n), where n is the length of the array.

Space Complexity: O(1), since only two variables are used.
*/

class Solution {
    public int findLengthOfLCIS(int[] nums) {

        int current = 1;
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                current++;
            } else {
                current = 1;
            }

            maxLength = Math.max(maxLength, current);
        }

        return maxLength;
    }
}
