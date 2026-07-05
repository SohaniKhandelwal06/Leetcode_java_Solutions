// Clear ith Bit

/*
Approach:
1. Create a bitmask by left-shifting 1 by i positions.
2. Complement the bitmask so that only the ith bit becomes 0 and all other bits become 1.
3. Perform a bitwise AND between the number and the complemented bitmask.
4. The ith bit is cleared while all other bits remain unchanged.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int clearBit(int n, int i) {
        return n & ~(1 << i);
    }
}
