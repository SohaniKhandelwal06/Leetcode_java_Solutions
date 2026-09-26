//Leetcode 166 - Fraction to Recurring Decimal

//
// Approach: HashMap + Long Division
//
// Perform long division and store the position where each remainder appears.
// If the same remainder appears again, the digits between the two positions
// form the recurring part, so insert ( at the first position and append ).
// Use long to safely handle Integer.MIN_VALUE.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }
}
