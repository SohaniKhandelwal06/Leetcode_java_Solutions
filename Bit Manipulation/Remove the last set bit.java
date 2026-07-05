// Remove the Last Set Bit

/*
Approach:
1. Subtract 1 from the given number.
2. Perform a bitwise AND between the number and (number - 1).
3. This clears the rightmost set bit while leaving all other bits unchanged.
4. Return the updated number.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int removeLastSetBit(int n) {
        return n & (n - 1);
    }
}
