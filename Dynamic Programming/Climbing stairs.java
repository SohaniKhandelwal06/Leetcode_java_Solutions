// Climbing Stairs
//
// =====================================================
// 1. Memoization (Top-Down DP)
// =====================================================
//
// Approach
// - Solve recursively.
// - Store computed answers in a DP array.
// - Return stored value if already computed.
//
// Time Complexity: O(N)
// Space Complexity: O(N) + O(N)

class Solution {

    public int climbStairs(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);

        return dp[n];
    }
}
// Climbing Stairs
//
// =====================================================
// 2. Tabulation (Bottom-Up DP)
// =====================================================
//
// Approach
// - Create a DP array.
// - Base cases:
//      dp[0] = 1
//      dp[1] = 1
// - Build the answer iteratively.
//
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    public int climbStairs(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
// Climbing Stairs
//
// =====================================================
// 3. Space Optimized DP
// =====================================================
//
// Approach
// - Only the previous two answers are needed.
// - Maintain two variables.
//
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {

    public int climbStairs(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {

            int curr = prev1 + prev2;

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
