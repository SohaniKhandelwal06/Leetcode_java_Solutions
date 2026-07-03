// Leetcode - 128 - Longest Consecutive Sequence

/*
Approach:
1. Store all the elements of the array in a HashSet for O(1) lookups.
2. Traverse each element in the set.
3. If the previous element (num - 1) is not present, it is the start of a new consecutive sequence.
4. Count the length of the sequence by checking for consecutive elements (num + 1, num + 2, ...).
5. Update the maximum sequence length.
6. Return the maximum length.

Time Complexity: O(N)
Space Complexity: O(N)
*/








class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
