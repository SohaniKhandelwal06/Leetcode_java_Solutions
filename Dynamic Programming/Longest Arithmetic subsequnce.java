//Leetcode 1027 - Longest Arithmetic Subsequence

//
// Approach: Dynamic Programming + HashMap
//
// For each index i, store the longest arithmetic subsequence ending
// at i for every possible difference.
// For a previous value nums[j], the required difference is
// nums[i] - nums[j].
// Extend the previous subsequence by one element and update the answer.
//
// Time Complexity:
// O(N²)
//
// Space Complexity:
// O(N²)
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int result = 2;

        List<HashMap<Integer, Integer>> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dp.add(new HashMap<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];

                int length = dp.get(j).getOrDefault(diff, 1) + 1;

                dp.get(i).put(diff, length);

                result = Math.max(result, length);
            }
        }

        return result;
    }
}
