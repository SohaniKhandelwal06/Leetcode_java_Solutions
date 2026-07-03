// GeeksforGeeks - Celebrity Problem


/*
Approach:
1. Initialize two pointers, top = 0 and down = n - 1.
2. Compare the two people:
   - If top knows down, top cannot be the celebrity.
   - Otherwise, down cannot be the celebrity.
3. Continue until only one candidate remains.
4. Verify the candidate:
   - The candidate should not know anyone.
   - Everyone else should know the candidate.
5. Return the candidate if both conditions are satisfied; otherwise return -1.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    int celebrity(int M[][], int n) {
        int top = 0;
        int down = n - 1;

        while (top < down) {
            if (M[top][down] == 1) {
                top++;
            } else if (M[down][top] == 1) {
                down--;
            } else {
                top++;
                down--;
            }
        }

        

        for (int i = 0; i < n; i++) {
            if (i != top) {
                if (M[top][i] == 1 || M[i][top] == 0) {
                    return -1;
                }
            }
        }

        return top;
    }
}
