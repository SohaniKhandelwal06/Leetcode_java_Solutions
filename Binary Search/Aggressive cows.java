// GFG - Aggressive Cows

/*
Approach (Binary Search on Answer):
1. Sort the stall positions.
2. The minimum possible distance is 1.
3. The maximum possible distance is:
      last stall - first stall.
4. Perform binary search on the minimum distance.
5. For each distance:
   - Place the first cow in the first stall.
   - Greedily place the remaining cows in the next stall
     that is at least 'distance' away.
6. If all cows can be placed, try a larger distance.
7. Otherwise, decrease the distance.
8. Return the largest valid minimum distance.

Time Complexity: O(N log N + N log(MaxDistance))
Space Complexity: O(1)
*/


class Solution {
    public static int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(stalls, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private static boolean canPlace(int[] stalls, int cows, int distance) {
        int count = 1;
        int lastPlaced = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= distance) {
                count++;
                lastPlaced = stalls[i];

                if (count >= cows) {
                    return true;
                }
            }
        }

        return false;
    }
}
