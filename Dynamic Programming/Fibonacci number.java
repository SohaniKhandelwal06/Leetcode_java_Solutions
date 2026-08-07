// Fibonacci Number
//
// =====================================================
// 1. Memoization (Top-Down DP)
// =====================================================
//
// Approach
// - Solve recursively.
// - Store computed Fibonacci values in a DP array.
// - If already computed, return the stored value.
//
// Time Complexity: O(N)
// Space Complexity: O(N) + O(N)
// (DP array + recursion stack)

class Solution {

    public int fib(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {

        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);

        return dp[n];
    }
}
// Fibonacci Number
//
// =====================================================
// 2. Tabulation (Bottom-Up DP)
// =====================================================
//
// Approach
// - Create a DP array.
// - Base Cases:
//      dp[0] = 0
//      dp[1] = 1
// - Compute Fibonacci numbers iteratively.
//
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
// Fibonacci Number
//
// =====================================================
// 3. Space Optimized DP
// =====================================================
//
// Approach
// - Only the previous two Fibonacci numbers
//   are needed.
// - Maintain two variables:
//      prev2 = F(i-2)
//      prev1 = F(i-1)
// - Compute the current Fibonacci number
//   and update the variables.
//
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {

    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        int prev2 = 0;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {

            int curr = prev1 + prev2;

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
