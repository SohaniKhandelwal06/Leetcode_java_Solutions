// XOR of Numbers in a Given Range

/*
Approach:
1. Compute the XOR of numbers from 1 to r.
2. Compute the XOR of numbers from 1 to (l - 1).
3. XOR these two results to obtain the XOR of numbers in the range [l, r].
4. Use the pattern of XOR from 1 to n:
   - If n % 4 == 0, XOR = n
   - If n % 4 == 1, XOR = 1
   - If n % 4 == 2, XOR = n + 1
   - If n % 4 == 3, XOR = 0

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int xorRange(int l, int r) {
        return xorUpto(r) ^ xorUpto(l - 1);
    }

    private int xorUpto(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0;
    }
}
