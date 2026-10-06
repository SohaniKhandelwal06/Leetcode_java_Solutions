//Leetcode 66 - Plus One

//
// Approach: Carry
//
// Start from the last digit and add one.
// If the digit becomes 10, set it to 0 and carry to the previous digit.
// Stop when no carry remains.
// If all digits were 9, create a new array with leading 1.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}
