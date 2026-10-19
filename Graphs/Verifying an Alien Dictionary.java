//Leetcode 953 - Verifying an Alien Dictionary
//
// Approach: Character Mapping
//
// Store each character's position in the alien alphabet using an array.
// Compare adjacent words character by character using their mapped positions.
// If the first differing character is out of order, return false.
// If one word is a prefix of another, the shorter word must come first.
//
// Time Complexity:
// O(N × L)
//
// Space Complexity:
// O(1)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] position = new int[26];

        for (int i = 0; i < order.length(); i++) {
            position[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int j = 0;
            int minLength = Math.min(first.length(), second.length());

            while (j < minLength &&
                   first.charAt(j) == second.charAt(j)) {
                j++;
            }

            if (j == minLength) {
                if (first.length() > second.length()) {
                    return false;
                }
            } else if (position[first.charAt(j) - 'a'] >
                       position[second.charAt(j) - 'a']) {
                return false;
            }
        }

        return true;
    }
}
