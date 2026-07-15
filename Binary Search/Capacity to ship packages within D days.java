// Leetcode - 1011 - Capacity To Ship Packages Within D Days

/*
Approach (Binary Search on Answer):
1. The minimum capacity is the maximum weight in the array.
2. The maximum capacity is the sum of all weights.
3. Perform binary search on the capacity.
4. For each capacity:
   - Simulate shipping the packages in order.
   - If adding the next package exceeds the capacity,
     start a new day.
5. If all packages can be shipped within the given days,
   try a smaller capacity.
6. Otherwise, increase the capacity.
7. Return the minimum valid capacity.

Time Complexity: O(N × log(SumOfWeights))
Space Complexity: O(1)
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possible(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possible(int[] weights, int capacity, int days) {
        int requiredDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight <= capacity) {
                currentLoad += weight;
            } else {
                requiredDays++;
                currentLoad = weight;
            }
        }

        return requiredDays <= days;
    }
}
