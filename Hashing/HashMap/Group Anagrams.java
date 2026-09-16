//Leetcode 49 - Group Anagrams

//
// Approach: HashMap + Sorting
//
// Anagrams have the same characters with the same frequencies.
// Sort the characters of each string. All anagrams will produce
// the same sorted string, which is used as the HashMap key.
//
// For example:
// "eat" -> "aet"
// "tea" -> "aet"
// "ate" -> "aet"
//
// So, all strings having the same key are stored in the same group.
//
// Steps:
// 1. Create a HashMap where key = sorted string.
// 2. For every string, convert it to a character array.
// 3. Sort the character array and create the key.
// 4. Add the original string to the list corresponding to that key.
// 5. Return all the lists from the HashMap.
//
// Time Complexity:
// O(N × K log K)
//
// Space Complexity:
// O(N × K)
import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string to character array
            char[] chars = str.toCharArray();

            // Sort characters to create common key
            Arrays.sort(chars);

            String key = new String(chars);

            // Add string to its anagram group
            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
