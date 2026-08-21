// Leetcode 1016 - Binary String With Substrings Representing 1 to N
//
// Approach:
// Convert every number from 1 to N into binary
// and check whether it exists in s.
//
// Time Complexity: O(N * log N)
// Space Complexity: O(log N)

class Solution {

    public boolean queryString(String s, int n) {

        for (int i = 1; i <= n; i++) {

            String binary =
                Integer.toBinaryString(i);

            if (!s.contains(binary)) {
                return false;
            }
        }

        return true;
    }
}
