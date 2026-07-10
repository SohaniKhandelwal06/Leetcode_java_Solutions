// Upper Bound

/*
Approach (Binary Search):
1. Initialize low = 0, high = n - 1, and ans = n.
2. Find the middle element.
3. If arr[mid] > target:
   - Store mid as a possible answer.
   - Continue searching in the left half for an earlier occurrence.
4. Otherwise, search in the right half.
5. Return the stored answer. If no element is greater than the target, return n.

Time Complexity: O(log N)
Space Complexity: O(1)
*/

class Solution {
    public int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
