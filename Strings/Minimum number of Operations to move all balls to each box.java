//Leetcode 1769 - Minimum Number of Operations to Move All Balls to Each Box

//
// Approach: Prefix Count + Running Cost
//
// Calculate the cost for every box using the number of balls seen
// on the left and right.
// Maintain the running cost and update it while moving from left to right.
// Each move changes the cost based on how many balls are on each side.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        int balls = 0;
        int operations = 0;

        // Cost for box 0
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                balls++;
                operations += i;
            }
        }

        result[0] = operations;

        int leftBalls = boxes.charAt(0) - '0';
        int rightBalls = balls - leftBalls;

        for (int i = 1; i < n; i++) {
            operations += leftBalls;
            operations -= rightBalls;

            result[i] = operations;

            if (boxes.charAt(i) == '1') {
                leftBalls++;
                rightBalls--;
            }
        }

        return result;
    }
}
