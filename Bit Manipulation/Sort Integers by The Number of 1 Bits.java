//LeetCode 1356 — Sort Integers by The Number of 1 Bits
/* Approach
Given an integer array arr, sort it according to:
1. The number of set bits (1s) in each integer's binary representation, in ascending order.
2. If two integers have the same number of set bits, sort them by their numerical value in ascending order.
Strategy: Custom Comparator
Java provides Integer.bitCount(num) to count the number of set bits in an integer.

Use Arrays.sort() with a custom comparator:
- First compare the number of set bits.
- If both numbers have the same count, compare their actual values.
This avoids manually implementing bit counting and makes the solution concise.
*/

import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);

            if (bitsA != bitsB) {
                return Integer.compare(bitsA, bitsB);
            }

            return Integer.compare(a, b);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }
}
