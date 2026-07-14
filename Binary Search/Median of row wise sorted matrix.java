// GFG - Median in a Row-wise Sorted Matrix

/*
Approach (Binary Search on Answer):
1. The median lies between the minimum element of the first column
   and the maximum element of the last column.
2. Perform binary search on this value range.
3. For each middle value, count how many elements are less than or
   equal to it by using Upper Bound on every row.
4. If the count is less than or equal to half the total elements,
   search in the higher half.
5. Otherwise, search in the lower half.
6. The first value satisfying the condition is the median.

Time Complexity: O(log(Max-Min) × N × log M)
Space Complexity: O(1)
*/

class Solution {
    int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find the minimum and maximum elements
        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        int req = (n * m) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int smallerEqual = 0;

            for (int i = 0; i < n; i++) {
                smallerEqual += upperBound(mat[i], mid);
            }

            if (smallerEqual <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private int upperBound(int[] arr, int target) {
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
