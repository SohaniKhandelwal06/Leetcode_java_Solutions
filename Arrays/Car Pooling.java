// LeetCode 1094 — Car Pooling
/* Approach
You are given a list of trips, where each trip is represented as:

trips[i] = [numPassengers, from, to]
- numPassengers: number of passengers picked up.
- from: pickup location.
- to: drop-off location.
The car travels only forward, and passengers are dropped off before new passengers are picked up at the same location. Determine whether the car can complete all trips without exceeding its capacity.
Strategy: Difference Array
Since locations are bounded, we can use an array to track changes in passenger count.

For each trip:
- Add numPassengers at from.
- Subtract numPassengers at to.
Then scan locations in order, maintaining the current passenger count. If it ever exceeds capacity, return false. If the scan finishes without exceeding capacity, return true.

Key insight: A pickup increases occupancy at the starting location, while a drop-off decreases occupancy at the destination.
*/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] changes = new int[1001];

        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            changes[from] += passengers;
            changes[to] -= passengers;
        }

        int passengersInCar = 0;

        for (int change : changes) {
            passengersInCar += change;

            if (passengersInCar > capacity) {
                return false;
            }
        }

        return true;
    }
}
