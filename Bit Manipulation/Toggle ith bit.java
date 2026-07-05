// Toggle ith Bit

/*
Approach:
1. Create a bitmask by left-shifting 1 by i positions.
2. Perform a bitwise XOR between the number and the bitmask.
3. If the ith bit is 0, it becomes 1.
4. If the ith bit is 1, it becomes 0.
5. Return the updated number.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int toggleBit(int n, int i) {
        return n ^ (1 << i);
    }
}
