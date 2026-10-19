//Leetcode 567 - Permutation in String
//
// Approach: Sliding Window + Frequency Count
//
// Count the character frequencies in s1.
// Maintain a sliding window of length s1.length() in s2.
// Update the window frequencies as characters enter and leave.
// If the window frequencies match s1, return true.
//
// Time Complexity:
// O(N + M)
//
// Space Complexity:
// O(1)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) return true;

        for (int i = n; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - n) - 'a']--;

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}
