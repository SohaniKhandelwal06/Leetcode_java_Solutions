//Leetcode 739 - Daily Temperatures

//
// Approach: Monotonic Decreasing Stack
//
// Store indices in the stack.
// Maintain temperatures in decreasing order from bottom to top.
// If the current temperature is greater than the temperature at
// stack top, pop the index and calculate the number of days.
//
// Time Complexity:
// O(N)
//
// Space Complexity: O(N





class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];

        // Monotonic decreasing stack
        // Stores indices
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Current temperature is warmer
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prev = stack.pop();

                // Number of days until warmer temperature
                ans[prev] = i - prev;
            }

            // Add current index
            stack.push(i);
        }

        return ans;
    }
}
