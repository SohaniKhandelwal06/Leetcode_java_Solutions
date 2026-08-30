// Sum of digits of a number
//
// Example:
// 12345 -> 1 + 2 + 3 + 4 + 5 = 15
//
// Time Complexity: O(log N)
// Space Complexity: O(1)

class Solution {

    public int sumOfDigits(int n) {

        n = Math.abs(n);

        int sum = 0;

        while (n != 0) {

            int digit = n % 10;

            sum += digit;

            n /= 10;
        }

        return sum;
    }
}
