// Leetcode 1392 - Longest Happy Prefix
//
// Approach: KMP / LPS
//
// The longest happy prefix is the longest proper
// prefix which is also a suffix.
//
// lps[n - 1] gives its length.
//
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    public String longestPrefix(String s) {

        int n = s.length();

        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        // Build LPS array
        while (i < n) {

            if (s.charAt(i) ==
                s.charAt(len)) {

                len++;

                lps[i] = len;

                i++;

            } else {

                if (len != 0) {

                    len = lps[len - 1];

                } else {

                    lps[i] = 0;

                    i++;
                }
            }
        }

        int length = lps[n - 1];

        return s.substring(0, length);
    }
}
