//LeetCode 28 — Find the Index of the First Occurrence in a String
/*Approach: Using substring()

We need to find the first occurrence of `needle` inside `haystack`.

1. Iterate through every possible starting index in `haystack`.
2. Extract a substring of length `needle.length()`.
3. Compare the extracted substring with `needle` using `.equals()`.
4. If they match, return the current index.
5. If no match is found, return `-1`.
*/




class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            String sub = haystack.substring(i, i + m);

            if (sub.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}


