//LeetCode 504 — Base 7
/* Approach
Given an integer num in base 10, convert it into a base-7 string.

In base 7, each digit ranges from 0 to 6.

For a positive number, repeatedly divide by 7 and collect the remainders. The remainders give the base-7 digits in reverse order, so reverse them at the end.

Handle these special cases:
- If num == 0, return "0".
- If num is negative, convert its absolute value and prepend "-".
  */

class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        boolean negative = num < 0;
        long number = Math.abs((long) num);

        StringBuilder result = new StringBuilder();

        while (number > 0) {
            result.append(number % 7);
            number /= 7;
        }

        if (negative) {
            result.append('-');
        }

        return result.reverse().toString();
    }
}
