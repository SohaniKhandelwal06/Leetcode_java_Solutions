
//Leetcode 171 - Excel Sheet Column Number

//
// Approach: Hashing / Character Mapping
//
// Each character represents a value from 1 to 26.
// For every character, multiply the current result by 26
// and add the value of the current character.
//
// Time Complexity:
// O(N)
//
// Space Complexity: O(1)
class Solution {

    public int titleToNumber(String columnTitle) {

        int result = 0;

        for (char ch : columnTitle.toCharArray()) {

            // Convert A-Z to 1-26
            int value = ch - 'A' + 1;

            // Shift previous value by base 26
            result = result * 26 + value;
        }

        return result;
    }
}
