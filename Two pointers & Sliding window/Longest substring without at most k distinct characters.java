// Longest Substring with At Most K Distinct Characters

/*
Approach (Sliding Window + HashMap):

1. Maintain a sliding window [left, right].
2. Use a HashMap to store:
      character -> frequency.
3. Expand the window by moving right.
4. If the number of distinct characters exceeds k,
   shrink the window from the left until
   map.size() <= k.
5. Update the maximum window length.

Why HashMap?
- It stores the frequency of each character.
- When a character's frequency becomes 0,
  remove it from the map.
- The map size always represents the number
  of distinct characters in the current window.

Time Complexity: O(N)
Space Complexity: O(K)
*/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
