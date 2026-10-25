//LeetCode 1395 — Count Number of Teams
/* Approach
You are given an array rating, where each element represents a soldier's rating.

Count the number of teams of three soldiers at indices \(i < j < k\) whose ratings are either:
- Increasing: rating[i] < rating[j] < rating[k]
- Decreasing: rating[i] > rating[j] > rating[k]
Simple approach: Three nested loops
Try every possible combination of three indices. For each combination, check whether the ratings are strictly increasing or strictly decreasing.

If either condition holds, increment the team count.

This approach is easy to understand and has \(O(n^3)\) time complexity. A more efficient solution can count valid teams in \(O(n^2)\) time by fixing the middle soldier.
Optimized approach: Fix the middle soldier
Choose each index j as the middle soldier of a potential team.

Count four quantities:
- leftSmaller: soldiers to the left of j with lower ratings.
- leftGreater: soldiers to the left of j with higher ratings.
- rightSmaller: soldiers to the right of j with lower ratings.
- rightGreater: soldiers to the right of j with higher ratings.
*/

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int teams = 0;

        for (int j = 0; j < n; j++) {
            int leftSmaller = 0;
            int leftGreater = 0;
            int rightSmaller = 0;
            int rightGreater = 0;

            // Count soldiers to the left of j
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftSmaller++;
                } else if (rating[i] > rating[j]) {
                    leftGreater++;
                }
            }

            // Count soldiers to the right of j
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    rightSmaller++;
                } else if (rating[k] > rating[j]) {
                    rightGreater++;
                }
            }

            // Increasing and decreasing teams
            teams += leftSmaller * rightGreater;
            teams += leftGreater * rightSmaller;
        }

        return teams;
    }
}

