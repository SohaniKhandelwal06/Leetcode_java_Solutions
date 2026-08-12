// Leetcode 1048 - Longest String Chain
//
// Approach: Dynamic Programming + HashMap
//
// dp[word] = longest chain ending at word
//
// For every word:
// Remove one character at a time.
// If the resulting string exists in the map,
// it can be the predecessor.
//
// Time Complexity: O(N * L^2)
// Space Complexity: O(N)
//
// N = number of words
// L = maximum word length

class Solution {

    public int longestStrChain(String[] words) {

        Arrays.sort(words,
            (a, b) -> a.length() - b.length());

        HashMap<String, Integer> dp =
            new HashMap<>();

        int ans = 1;

        for (String word : words) {

            int best = 1;

            // Remove one character
            for (int i = 0; i < word.length(); i++) {

                String prev =
                    word.substring(0, i) +
                    word.substring(i + 1);

                if (dp.containsKey(prev)) {

                    best = Math.max(
                        best,
                        dp.get(prev) + 1
                    );
                }
            }

            dp.put(word, best);

            ans = Math.max(ans, best);
        }

        return ans;
    }
}
