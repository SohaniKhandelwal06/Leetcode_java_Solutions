// Leetcode 140 - Word Break II
//
// Approach: DFS + Memoization
//
// For every index, try every possible word.
// Store results for each index to avoid recomputation.
//
// Time Complexity: Exponential in the worst case
// Space Complexity: O(N) recursion + memoization
//
// Note: Output itself can be exponential.

class Solution {

    public List<String> wordBreak(
            String s,
            List<String> wordDict) {

        HashSet<String> set =
            new HashSet<>(wordDict);

        HashMap<Integer, List<String>> memo =
            new HashMap<>();

        return dfs(s, 0, set, memo);
    }

    private List<String> dfs(
            String s,
            int index,
            HashSet<String> set,
            HashMap<Integer, List<String>> memo) {

        if (index == s.length()) {
            return new ArrayList<>(
                List.of("")
            );
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        List<String> ans =
            new ArrayList<>();

        for (int end = index + 1;
             end <= s.length();
             end++) {

            String word =
                s.substring(index, end);

            if (!set.contains(word)) {
                continue;
            }

            List<String> remaining =
                dfs(
                    s,
                    end,
                    set,
                    memo
                );

            for (String suffix : remaining) {

                if (suffix.isEmpty()) {
                    ans.add(word);
                } else {
                    ans.add(
                        word + " " + suffix
                    );
                }
            }
        }

        memo.put(index, ans);

        return ans;
    }
}
