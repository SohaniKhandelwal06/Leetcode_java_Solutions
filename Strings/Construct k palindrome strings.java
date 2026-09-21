//Leetcode 1400 - Construct K Palindrome Strings

//
// Approach: Frequency Count
//
// A string can form a palindrome if at most one character has an odd frequency.
// Count the frequency of every character and count how many have odd frequencies.
// Each odd-frequency character requires a separate palindrome.
// If the number of odd frequencies is greater than k, it is impossible.
// Also, we need at least k characters to form k non-empty palindromes.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(1)
class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;

        for (int count : freq) {
            if (count % 2 != 0) {
                odd++;
            }
        }

        return odd <= k;
    }
}
