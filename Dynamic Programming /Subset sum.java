// 0/1 Subset Sum
//
// Count the number of subsets whose sum is equal to target.
// Each element can be used at most once.
//
// dp[j] = number of subsets with sum j.
//
// If we take num:
//     dp[j - num] ways are added to dp[j]
//
// Time Complexity: O(N * target)
// Space Complexity: O(target)

class Solution {

    public int countSubsets(int[] arr, int target) {

        int[] dp = new int[target + 1];

        // Empty subset gives sum 0
        dp[0] = 1;

        for (int num : arr) {

            // Traverse backwards so that
            // each element is used only once.
            for (int j = target; j >= num; j--) {

                dp[j] = dp[j] + dp[j - num];
            }
        }

        return dp[target];
    }
}
