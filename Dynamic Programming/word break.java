// Leetcode 139 - Word Break
//
// Approach: Dynamic Programming
//
// dp[i] = true if s[0...i-1] can be segmented
//         using words from wordDict.
//
// Time Complexity: O(N^2)
// Space Complexity: O(N)

class Solution {

    public boolean wordBreak(
            String s,
            List<String> wordDict) {

        HashSet<String> set =
            new HashSet<>(wordDict);

        int n = s.length();

        boolean[] dp =
            new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] &&
                    set.contains(
                        s.substring(j, i)
                    )) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
