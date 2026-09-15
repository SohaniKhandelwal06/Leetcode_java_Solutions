//Leetcode 1470 - Shuffle the Array

//
// Approach: Two Pointer
//
// The array is arranged as [x1, x2, ..., xn, y1, y2, ..., yn].
// Traverse the first half and second half together, placing xi and yi
// alternately into the result array.
//
// Time Complexity: O(N)
//
// Space Complexity: O(N)
class Solution {

    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[2 * n];

        int index = 0;

        for (int i = 0; i < n; i++) {

            // Add xi
            ans[index++] = nums[i];

            // Add yi
            ans[index++] = nums[i + n];
        }

        return ans;
    }
}
