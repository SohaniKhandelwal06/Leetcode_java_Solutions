// GFG - Nth Root of an Integer

/*
Approach (Binary Search):
1. The nth root of m lies between 1 and m.
2. Perform binary search on this range.
3. For each middle value, compute mid^n.
4. If mid^n equals m, return mid.
5. If mid^n is less than m, search in the right half.
6. If mid^n is greater than m, search in the left half.
7. If no integer nth root exists, return -1.

Time Complexity: O(N × log M)
Space Complexity: O(1)
*/


class Solution {

    public int NthRoot(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int value = check(mid, n, m);

            if (value == 1) {
                return mid;
            } else if (value == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    
    private int check(int mid, int n, int m) {
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans *= mid;

            if (ans > m) {
                return 2;
            }
        }

        if (ans == m) {
            return 1;
        }

        return 0;
    }
}
