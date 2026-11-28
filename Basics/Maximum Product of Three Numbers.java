//LeetCode 628 - Maximum Product of Three Numbers

/*Approach: Sorting

Sort the array in ascending order.

The maximum product of three numbers can be obtained from either:

The three largest numbers.

The two smallest numbers (possibly negative) and the largest number.

Negative numbers can produce a positive product when multiplied together.

After sorting, compare these two possibilities and return the maximum.
Complexity Analysis

Time Complexity: O(n log n), due to sorting.

Space Complexity: O(1) auxiliary space, excluding the sorting implementation.
*/

import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        int product2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(product1, product2);
    }
}
