// Leetcode 45 - Jump Game II
//
// Approach (Greedy)
//
// - Maintain the farthest reachable index.
// - currentEnd represents the end of the
//   current jump.
// - When current index reaches currentEnd,
//   take one jump and extend the range.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(1)

class Solution {

    public int jump(int[] nums) {

        int jumps = 0;
        int maxReach = 0;
        int currentEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            maxReach = Math.max(
                maxReach,
                i + nums[i]
            );

            if (i == currentEnd) {

                jumps++;
                currentEnd = maxReach;
            }
        }

        return jumps;
    }
}
