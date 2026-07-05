// Leetcode - 342 - Power of Four

/*
Approach:
1. Check if the number is positive.
2. Verify that it is a power of two by ensuring n & (n - 1) == 0.
3. Use the bitmask 0x55555555 to ensure the only set bit is at an odd position (0, 2, 4, ...), which is true only for powers of 4.
4. Return true if all conditions are satisfied; otherwise, return false.

Time Complexity: O(1)
Space Complexity: O(1)
*/
class  Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 
            && (n & (n - 1)) == 0 
            && (n & 0x55555555) !=0;
    }
}
