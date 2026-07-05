// Leetcode - 191 - Number of 1 Bits

/*
Approach:
1. Initialize a counter to 0.
2. Repeatedly perform n = n & (n - 1), which removes the rightmost set bit.
3. Increment the counter after each removal.
4. Continue until n becomes 0.
5. Return the total count of set bits.

Time Complexity: O(Number of Set Bits)
Space Complexity: O(1)
*/





class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }
}
