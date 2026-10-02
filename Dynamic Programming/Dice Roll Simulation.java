//Leetcode 1223 - Dice Roll Simulation

//
// Approach: Dynamic Programming
//
// dp[i][j][k] represents the number of valid sequences of length i
// ending with face j repeated k times.
// For each new roll, choose a different face or extend the current
// face's streak if it does not exceed its roll limit.
// Use modulo to keep values within the required range.
//
// Time Complexity:
// O(N × 6 × 15)
//
// Space Complexity:
// O(N × 6 × 15)
class Solution {
    private static final int MOD = 1_000_000_007;

    public int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n + 1][6][16];

        for (int face = 0; face < 6; face++) {
            dp[1][face][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int face = 0; face < 6; face++) {
                for (int prev = 0; prev < 6; prev++) {
                    for (int streak = 1; streak <= rollMax[prev]; streak++) {
                        int ways = dp[i - 1][prev][streak];

                        if (ways == 0) continue;

                        if (face == prev) {
                            if (streak < rollMax[face]) {
                                dp[i][face][streak + 1] =
                                    (int) ((dp[i][face][streak + 1] + (long) ways) % MOD);
                            }
                        } else {
                            dp[i][face][1] =
                                (int) ((dp[i][face][1] + (long) ways) % MOD);
                        }
                    }
                }
            }
        }

        int result = 0;

        for (int face = 0; face < 6; face++) {
            for (int streak = 1; streak <= rollMax[face]; streak++) {
                result = (int) ((result + (long) dp[n][face][streak]) % MOD);
            }
        }

        return result;
    }
}
