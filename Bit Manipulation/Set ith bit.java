// Set ith Bit

/*
Approach:
1. Create a bitmask by left-shifting 1 by i positions.
2. Perform a bitwise OR between the number and the bitmask.
3. The ith bit becomes set while all other bits remain unchanged.
4. Return the updated number.

Time Complexity: O(1)
Space Complexity: O(1)
*/
class Solution {
    public int setBit(int n, int i) {
        return n | (1 << i);
    }
}
