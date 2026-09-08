//Leetcode 3870 - Count Commas

//
// Approach: Mathematical Counting
//
// Count how many numbers from 1 to n contain a comma
// when written with standard thousands separators.
// Every number from 1,000 to 999,999 contains exactly 1 comma.
// Every number from 1,000,000 to 999,999,999 contains 2 commas,
// and so on.
//
// Time Complexity:
// O(log N)
//
// Space Complexity: O(1)
  class Solution {

    public long countCommas(long n) {

        long result = 0;
        long start = 1000;
        long commaCount = 1;

        while (start <= n) {

            long end = start * 1000 - 1;

            if (end > n) {
                end = n;
            }

            result += (end - start + 1) * commaCount;

            start *= 1000;
            commaCount++;
        }

        return result;
    }
}
