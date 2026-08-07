// Leetcode 135 - Candy
//
// Approach (Greedy - Slope Technique)
//
// - Track increasing and decreasing slopes.
// - Count candies while traversing once.
// - Handle peak separately to avoid double counting.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(1)

class Solution {

    public int candy(int[] ratings) {

        int n = ratings.length;

        if (n == 1) {
            return 1;
        }

        int candies = 1;

        int up = 0;
        int down = 0;
        int peak = 0;

        for (int i = 1; i < n; i++) {

            if (ratings[i] > ratings[i - 1]) {

                up++;
                peak = up;
                down = 0;

                candies += 1 + up;
            }

            else if (ratings[i] == ratings[i - 1]) {

                up = 0;
                down = 0;
                peak = 0;

                candies += 1;
            }

            else {

                down++;
                up = 0;

                candies += 1 + down;

                if (down <= peak) {
                    candies--;
                }
            }
        }

        return candies;
    }
}
