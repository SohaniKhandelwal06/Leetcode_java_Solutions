// Leetcode 1053 - Previous Permutation With One Swap
//
// Approach: Greedy
//
// 1. Find the first index i from the right where
//    nums[i] > nums[i + 1].
// 2. Find the largest element on the right that is
//    smaller than nums[i].
// 3. If duplicates exist, choose the rightmost occurrence.
// 4. Swap.
//
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {

    public int[] prevPermOpt1(int[] arr) {

        int n = arr.length;

        // Step 1: Find first decreasing position
        int i = n - 2;

        while (i >= 0 &&
               arr[i] <= arr[i + 1]) {

            i--;
        }

        // Already the smallest permutation
        if (i < 0) {
            return arr;
        }

        // Step 2: Find the rightmost element
        // smaller than arr[i]
        int j = n - 1;

        while (j > i &&
               arr[j] >= arr[i]) {

            j--;
        }

        // Skip duplicates so that we choose
        // the rightmost occurrence
        while (j > i + 1 &&
               arr[j] == arr[j - 1]) {

            j--;
        }

        // Step 3: Swap
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }
}
