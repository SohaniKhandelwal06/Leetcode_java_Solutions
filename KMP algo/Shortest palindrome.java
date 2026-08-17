// Leetcode 214 - Shortest Palindrome
//
// Approach: KMP / LPS
//
// Find the longest palindromic prefix.
// Create:
// s + "#" + reverse(s)
//
// The last value of the LPS array gives the
// length of the longest palindromic prefix.
//
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    public String shortestPalindrome(String s) {

        String rev =
            new StringBuilder(s)
                .reverse()
                .toString();

        String combined =
            s + "#" + rev;

        int[] lps =
            buildLPS(combined);

        int palLength =
            lps[combined.length() - 1];

        String remaining =
            s.substring(palLength);

        String add =
            new StringBuilder(remaining)
                .reverse()
                .toString();

        return add + s;
    }

    private int[] buildLPS(String s) {

        int n = s.length();

        int[] lps = new int[n];

        int len = 0;
        int i = 1;

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

        return lps;
    }
}
