// Leetcode - 76 - Minimum Window Substring

/*
Approach (Sliding Window + HashMap)

Observation:
Find the smallest substring of s that contains
all characters of t (including duplicates).

Algorithm:

1. Store the frequency of characters of t in a HashMap.
2. Expand the window by moving right.
3. If the current character belongs to t:
      decrease its frequency.
4. Whenever a required character is found
   (frequency >= 0), increase count.
5. When count == t.length(),
   the current window is valid.
6. Try shrinking the window from the left
   while it remains valid.
7. Update the minimum window length.
8. Return the smallest substring.

Time Complexity: O(N)
Space Complexity: O(M)
where M is the number of distinct characters in t.
*/

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) >= 0) {
                    count++;
                }
            }

            while (count == t.length()) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) > 0) {
                        count--;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
