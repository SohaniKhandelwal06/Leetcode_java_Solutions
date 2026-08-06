// Leetcode 55 - Jump Game
//
// Approach (Greedy)
//
// - Maintain the farthest reachable index.
// - If current index is beyond the farthest
//   reachable index, return false.
// - Otherwise update the farthest reach.
// - If the last index becomes reachable,
//   return true.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(1)

class Solution {

    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(
                maxReach,
                i + nums[i]
            );

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
