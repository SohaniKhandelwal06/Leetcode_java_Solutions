// Leetcode 1478 - Allocate Mailboxes
//
// Approach: DP + Median
//
// Sort houses.
// For houses i...j, the optimal mailbox position
// is the median house.
//
// cost[i][j] = minimum distance for houses i...j
//              using one mailbox.
//
// dp[k][i] = minimum distance for first i houses
//            using k mailboxes.
//
// Time Complexity: O(K * N^2)
// Space Complexity: O(N^2 + K * N)

class Solution {

    public int minDistance(int[] houses, int k) {

        Arrays.sort(houses);

        int n = houses.length;

        int[][] cost = new int[n][n];

        // Calculate cost of one mailbox
        // for every interval [i...j].
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int mid = (i + j) / 2;

                int total = 0;

                for (int x = i; x <= j; x++) {

                    total +=
                        Math.abs(
                            houses[x] - houses[mid]
                        );
                }

                cost[i][j] = total;
            }
        }

        int INF = Integer.MAX_VALUE / 2;

        int[][] dp =
            new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // 0 houses require 0 distance
        dp[0][0] = 0;

        for (int mailboxes = 1;
             mailboxes <= k;
             mailboxes++) {

            for (int housesCount = 1;
                 housesCount <= n;
                 housesCount++) {

                // Last mailbox serves houses j...housesCount-1
                for (int j = 0;
                     j < housesCount;
                     j++) {

                    dp[mailboxes][housesCount] =
                        Math.min(
                            dp[mailboxes][housesCount],
                            dp[mailboxes - 1][j]
                            + cost[j][housesCount - 1]
                        );
                }
            }
        }

        return dp[k][n];
    }
}
