//Leetcode 1156 - Swap For Longest Repeated Character Substring

//
// Approach: Sliding Window + Frequency Count
//
// Count the total frequency of each character.
// For every character, use a sliding window containing only that character
// with at most one different character. This different character can be
// swapped with another occurrence of the required character.
// The maximum possible length is limited by the total frequency of that character.
//
// Time Complexity: O(N)
//
// Space Complexity: O(1)
class Solution {

    public int maxRepOpt1(String text) {

        int[] total = new int[26];

        // Total frequency of each character
        for (char ch : text.toCharArray()) {
            total[ch - 'a']++;
        }

        int ans = 0;

        for (int c = 0; c < 26; c++) {

            if (total[c] == 0) {
                continue;
            }

            int left = 0;
            int count = 0;

            // Sliding window
            for (int right = 0; right < text.length(); right++) {

                if (text.charAt(right) - 'a' == c) {
                    count++;
                }

                // More than one different character
                while ((right - left + 1) - count > 1) {

                    if (text.charAt(left) - 'a' == c) {
                        count--;
                    }

                    left++;
                }

                // Cannot exceed total frequency of character c
                ans = Math.max(
                    ans,
                    Math.min(right - left + 1, total[c])
                );
            }
        }

        return ans;
    }
}
