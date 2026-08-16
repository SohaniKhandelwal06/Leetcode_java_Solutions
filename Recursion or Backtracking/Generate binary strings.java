// Generate all binary strings of length n
//
// Approach: Recursion / Backtracking
//
// Time Complexity: O(2^N)
// Space Complexity: O(N) excluding the answer

class Solution {

    public List<String> generateBinaryStrings(int n) {

        List<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        solve(0, n, sb, ans);

        return ans;
    }

    private void solve(
            int index,
            int n,
            StringBuilder sb,
            List<String> ans) {

        // String is complete
        if (index == n) {

            ans.add(sb.toString());

            return;
        }

        // Choose 0
        sb.append('0');

        solve(index + 1, n, sb, ans);

        sb.deleteCharAt(sb.length() - 1);

        // Choose 1
        sb.append('1');

        solve(index + 1, n, sb, ans);

        sb.deleteCharAt(sb.length() - 1);
    }
}
