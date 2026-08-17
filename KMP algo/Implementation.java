KMP // KMP (Knuth-Morris-Pratt) String Matching Algorithm
//
// Finds the first occurrence of pattern in text.
//
// Time Complexity: O(N + M)
// Space Complexity: O(M)
//
// N = length of text
// M = length of pattern

class Solution {

    public int strStr(String text, String pattern) {

        if (pattern.length() == 0) {
            return 0;
        }

        int[] lps = buildLPS(pattern);

        int i = 0; // text pointer
        int j = 0; // pattern pointer

        while (i < text.length()) {

            if (text.charAt(i) ==
                pattern.charAt(j)) {

                i++;
                j++;

                // Complete pattern found
                if (j == pattern.length()) {
                    return i - j;
                }

            } else {

                if (j != 0) {

                    // Do not move i
                    j = lps[j - 1];

                } else {

                    i++;
                }
            }
        }

        return -1;
    }

    // Build LPS array
    //
    // LPS = Longest Proper Prefix
    //       which is also a Suffix

    private int[] buildLPS(String pattern) {

        int n = pattern.length();

        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {

            if (pattern.charAt(i) ==
                pattern.charAt(len)) {

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
