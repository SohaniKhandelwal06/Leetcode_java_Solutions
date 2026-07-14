// GFG - Row with Max 1s

/*
Approach (Binary Search):
1. Since each row is sorted, use Binary Search to find the first occurrence of 1 in every row.
2. Number of 1s in a row = total columns - index of first 1.
3. Keep track of the row having the maximum number of 1s.
4. Return its index. If no row contains a 1, return -1.

Time Complexity: O(N × log M)
Space Complexity: O(1)
*/

class Solution {

    public int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int maxOnes = 0;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            int firstOne = lowerBound(arr[i], 1);
            int ones = m - firstOne;

            if (ones > maxOnes) {
                maxOnes = ones;
                ans = i;
            }
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
