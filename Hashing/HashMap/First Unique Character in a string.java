//Leetcode 387 - First Unique Character in a String

//
// Approach: HashMap / Frequency Count
//
// First count the frequency of every character using a HashMap.
// Then traverse the string again and return the index of the first
// character whose frequency is 1.
//
// Time Complexity:
// O(N)
//
// Space Complexity: O(N)






class Solution {

    public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
