// Leetcode 216 - Combination Sum III
//
// Choose k distinct numbers from 1 to 9
// such that their sum is n.
//
// Approach: Backtracking
//
// Time Complexity: O(C(9, k))
// Space Complexity: O(k) excluding the answer

class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        backtrack(
            1,
            k,
            n,
            temp,
            ans
        );

        return ans;
    }

    private void backtrack(
            int start,
            int k,
            int target,
            List<Integer> temp,
            List<List<Integer>> ans) {

        // Combination complete
        if (temp.size() == k) {

            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }

            return;
        }

        for (int i = start; i <= 9; i++) {

            // Remaining target cannot be negative
            if (i > target) {
                break;
            }

            temp.add(i);

            backtrack(
                i + 1,
                k,
                target - i,
                temp,
                ans
            );

            temp.remove(temp.size() - 1);
        }
    }
}
