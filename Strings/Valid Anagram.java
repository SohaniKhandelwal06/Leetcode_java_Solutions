//Leetcode 242 - Valid Anagram

//
// Approach: HashMap
//
// map -> stores frequency of each character
// increment frequency for s
// decrement frequency for t
//
// Time Complexity:
// O(N)
//
// Space Complexity: O(N)class Solution {

    public boolean isAnagram(String s, String t) {

        // Anagrams must have same length
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters in s
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Remove characters using t
        for (char ch : t.toCharArray()) {

            if (!map.containsKey(ch)) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);

            // Remove character when frequency becomes zero
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        return map.isEmpty();
    }
}
