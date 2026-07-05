// Binary to Decimal

/*
Approach:
1. Traverse the binary string from right to left.
2. Maintain the current power of 2.
3. If the current bit is 1, add 2^power to the decimal value.
4. Increment the power after processing each bit.
5. Return the decimal value.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += (1 << power);
            }
            power++;
        }

        return decimal;
    }
}
