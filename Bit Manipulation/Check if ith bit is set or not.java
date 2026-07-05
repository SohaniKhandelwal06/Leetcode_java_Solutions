// Check if ith Bit is Set or Not

/*
Approach:
1. Create a bitmask by left-shifting 1 by i positions.
2. Perform a bitwise AND between the number and the bitmask.
3. If the result is non-zero, the ith bit is set.
4. Otherwise, the ith bit is not set.

Time Complexity: O(1)
Space Complexity: O(1)
*/
class Solution {
    public boolean isSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}
