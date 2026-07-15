// Leetcode - 1901 - Find a Peak Element II

/*
Approach (Binary Search on Columns):
1. Perform binary search on the columns.
2. For each middle column, find the row containing the maximum element.
3. Compare this element with its left and right neighbors.
4. If it is greater than both neighbors, it is a peak.
5. If the left neighbor is greater, search the left half.
6. Otherwise, search the right half.
7. Return the position of the peak.

Time Complexity: O(M × log N)
Space Complexity: O(1)
*/
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Find the row with the maximum element in the middle column
            int maxRow = 0;
            for (int i = 1; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int left = (mid == 0) ? -1 : mat[maxRow][mid - 1];
            int right = (mid == n - 1) ? -1 : mat[maxRow][mid + 1];

            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            } else if (left > mat[maxRow][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
  }
