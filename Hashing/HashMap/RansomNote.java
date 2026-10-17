//Leetcode 383 - Ransom Note
//
// Approach: HashMap
//
// Count the frequency of each character in magazine using a HashMap.
// Traverse ransomNote and check whether each character is available.
// If its frequency is zero or the character is missing, return false.
// Otherwise, decrease its frequency and continue.
//
// Time Complexity:
// O(N + M)
//
// Space Complexity:
// O(1) — at most 26 lowercase English letters
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }

            map.put(c, map.get(c) - 1);
        }

        return true;
    }
}
