
// GFG - Minimize Max Distance to Gas Station

/*
Approach (Binary Search on Answer):
1. The answer lies between:
   - 0 (minimum possible distance)
   - Maximum distance between two consecutive stations.
2. Perform binary search on the maximum allowed distance.
3. For each candidate distance:
   - Count how many additional stations are needed so that
     every adjacent gap is at most the candidate distance.
4. If the required stations are within k,
   try a smaller maximum distance.
5. Otherwise, increase the allowed distance.
6. Continue until the required precision (1e-6) is reached.

Time Complexity: O(N × log(MaxDistance / Precision))
Space Complexity: O(1)
*/





class Solution {

    public static double findSmallestMaxDist(int[] stations, int k) {
        double low = 0;
        double high = 0;

        for (int i = 1; i < stations.length; i++) {
            high = Math.max(high, stations[i] - stations[i - 1]);
        }

        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2.0;

            if (possible(stations, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    private static boolean possible(int[] stations, int k, double dist) {
        int count = 0;

        for (int i = 1; i < stations.length; i++) {
            count += (int) ((stations[i] - stations[i - 1]) / dist);

            // If exactly divisible, one fewer station is needed
            if ((stations[i] - stations[i - 1]) == dist * (int)((stations[i] - stations[i - 1]) / dist)) {
                count--;
            }
        }

        return count <= k;
    }
}
