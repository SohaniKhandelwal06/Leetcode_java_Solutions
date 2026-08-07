// Frog Jump
//
// =====================================================
// 1. Memoization (Top-Down DP)
// =====================================================
//
// Approach
// - Solve recursively.
// - Store answers in a DP array.
// - At each stair,
//   take the minimum of:
//      1-step jump
//      2-step jump
//
// Time Complexity: O(N)
// Space Complexity: O(N) + O(N)

class Solution {

    public int minimumEnergy(int[] height, int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n - 1, height, dp);
    }

    private int solve(int ind,
                      int[] height,
                      int[] dp) {

        if (ind == 0)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int left =
            solve(ind - 1, height, dp)
            + Math.abs(
                height[ind]
                - height[ind - 1]);

        int right = Integer.MAX_VALUE;

        if (ind > 1) {

            right =
                solve(ind - 2, height, dp)
                + Math.abs(
                    height[ind]
                    - height[ind - 2]);
        }

        return dp[ind] =
            Math.min(left, right);
    }
}
// Frog Jump
//
// =====================================================
// 2. Tabulation (Bottom-Up DP)
// =====================================================
//
// Approach
// - dp[i] stores the minimum energy
//   to reach stair i.
// - Build from left to right.
//
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    public int minimumEnergy(int[] height, int n) {

        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int left =
                dp[i - 1]
                + Math.abs(
                    height[i]
                    - height[i - 1]);

            int right =
                Integer.MAX_VALUE;

            if (i > 1) {

                right =
                    dp[i - 2]
                    + Math.abs(
                        height[i]
                        - height[i - 2]);
            }

            dp[i] =
                Math.min(left, right);
        }

        return dp[n - 1];
    }
}
// Frog Jump
//
// =====================================================
// 3. Space Optimized DP
// =====================================================
//
// Approach
// - Only previous two DP states
//   are required.
//
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {

    public int minimumEnergy(int[] height, int n) {

        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {

            int left =
                prev
                + Math.abs(
                    height[i]
                    - height[i - 1]);

            int right =
                Integer.MAX_VALUE;

            if (i > 1) {

                right =
                    prev2
                    + Math.abs(
                        height[i]
                        - height[i - 2]);
            }

            int curr =
                Math.min(left, right);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
