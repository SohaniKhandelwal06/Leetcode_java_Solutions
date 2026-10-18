//Leetcode 941 - Valid Mountain Array
//
// Approach: Two Pointers
//
// Move the left pointer upward while the array is strictly increasing.
// Move the right pointer downward while the array is strictly decreasing.
// A valid mountain must have a peak that is neither the first nor last element.
// If both pointers meet at the same peak, return true.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(1)
class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        if (n < 3) return false;

        int left = 0;
        int right = n - 1;

        while (left + 1 < n && arr[left] < arr[left + 1]) {
            left++;
        }

        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }

        return left == right && left > 0 && right < n - 1;
    }
}
