// Shortest Job First (SJF)
//
// Approach (Greedy)
//
// - Sort burst times.
// - Execute the shortest process first.
// - Waiting time for a process
//   equals the total execution time
//   of all previous processes.
// - Return the average waiting time.
//
// Time Complexity:
// O(N log N)
//
// Space Complexity:
// O(1)

class Solution {

    static long solve(int[] bt) {

        Arrays.sort(bt);

        long waitingTime = 0;
        long currentTime = 0;

        for (int burst : bt) {

            waitingTime += currentTime;

            currentTime += burst;
        }

        return waitingTime / bt.length;
    }
}
