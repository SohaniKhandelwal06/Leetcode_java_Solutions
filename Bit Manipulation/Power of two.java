// Leetcode - 231 - Power of Two

/*
Approach:
1. A power of two has exactly one set bit in its binary representation.
2. Subtracting 1 from such a number flips that set bit and all lower bits.
3. Perform a bitwise AND between the number and (number - 1).
4. If the result is 0 and the number is positive, it is a power of two.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}
