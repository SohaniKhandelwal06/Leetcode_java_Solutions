//LeetCode 961 — N-Repeated Element in Size 2N Array
/* Approach
You are given an array nums of size 2N. One element appears exactly N times, while every other element is unique. Return the repeated element.

Simple approach: Use a HashSet.
- Traverse the array from left to right.
- If an element is already in the set, return it.
- Otherwise, add it to the set.
The first duplicate encountered is the answer.
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
}
