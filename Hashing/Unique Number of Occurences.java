//Leetcode 1207 - Unique Number of Occurrences

//
// Approach: HashMap + HashSet
//
// Count the frequency of every number using a HashMap.
// Store each frequency in a HashSet.
// If a frequency already exists in the set, two numbers have the
// same occurrence count, so return false.
// Otherwise, all occurrence counts are unique.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int count : map.values()) {
            if (!set.add(count)) {
                return false;
            }
        }

        return true;
    }
}
