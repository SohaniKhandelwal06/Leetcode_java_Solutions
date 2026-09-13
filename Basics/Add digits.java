//Leetcode 258 - Add Digits

//
// Approach: Digit Sum
//
// Extract each digit using % 10 and add it to the sum.
// Repeat until the number becomes a single digit.
//
// Time Complexity: O(log N)
//
// Space Complexity: O(1)
class Solution {

    public int addDigits(int num) {

        while (num >= 10) {

            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            num = sum;
        }

        return num;
    }
}
