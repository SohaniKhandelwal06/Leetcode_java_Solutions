// Leetcode 300 - Longest Increasing Subsequence
//
// Approach: Memoization
//
// dp[i] = LIS length ending at index i
//
// Time Complexity: O(N^2)
// Space Complexity: O(N) + O(N) recursion stack

class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        int ans = 0;

        for (int i = 0; i < n; i++) {

            ans = Math.max(
                ans,
                solve(i, nums, dp)
            );
        }

        return ans;
    }

    private int solve(int ind,
                      int[] nums,
                      int[] dp) {

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int maxLen = 1;

        for (int prev = 0; prev < ind; prev++) {

            if (nums[prev] < nums[ind]) {

                maxLen = Math.max(
                    maxLen,
                    1 + solve(prev, nums, dp)
                );
            }
        }

        return dp[ind] = maxLen;
    }
}
// Leetcode 300 - Longest Increasing Subsequence
//
// Approach: Tabulation
//
// dp[i] = length of LIS ending at index i
//
// Time Complexity: O(N^2)
// Space Complexity: O(N)

class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int ans = 1;

        for (int i = 0; i < n; i++) {

            for (int prev = 0; prev < i; prev++) {

                if (nums[prev] < nums[i]) {

                    dp[i] = Math.max(
                        dp[i],
                        dp[prev] + 1
                    );
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}// Leetcode 300 - Longest Increasing Subsequence
//
// Approach: Binary Search
//
// Time Complexity: O(N log N)
// Space Complexity: O(N)

class Solution {

    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {

            int left = 0;
            int right = list.size();

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (list.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == list.size()) {
                list.add(num);
            } else {
                list.set(left, num);
            }
        }

        return list.size();
    }
}
