// Leetcode 1105 - Filling Bookcase Shelves
//
// Approach: Dynamic Programming
//
// dp[i] = minimum total height needed
//         to place the first i books.
//
// For every i, try putting the last books
// on the same shelf while total thickness
// does not exceed shelfWidth.
//
// Time Complexity: O(N^2)
// Space Complexity: O(N)

class Solution {

    public int minHeightShelves(
            int[][] books,
            int shelfWidth) {

        int n = books.length;

        int[] dp = new int[n + 1];

        Arrays.fill(
            dp,
            Integer.MAX_VALUE
        );

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            int width = 0;
            int maxHeight = 0;

            // Put books j...i-1
            // on the current shelf.
            for (int j = i; j >= 1; j--) {

                width += books[j - 1][0];

                if (width > shelfWidth) {
                    break;
                }

                maxHeight = Math.max(
                    maxHeight,
                    books[j - 1][1]
                );

                dp[i] = Math.min(
                    dp[i],
                    dp[j - 1] + maxHeight
                );
            }
        }

        return dp[n];
    }
}
