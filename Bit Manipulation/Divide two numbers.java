// Leetcode - 29 - Divide Two Integers

/*
Approach:
1. Handle the overflow case when dividend is Integer.MIN_VALUE and divisor is -1.
2. Convert both numbers to positive long values.
3. Repeatedly find the largest power of 2 multiple of the divisor that can be subtracted from the dividend.
4. Add the corresponding power of 2 to the quotient and subtract the multiple from the dividend.
5. Apply the correct sign to the quotient based on the signs of the dividend and divisor.

Time Complexity: O(log² N)
Space Complexity: O(1)
*/
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int ans = 0;

        while (dvd >= dvs) {
            int count = 0;

            while (dvd >= (dvs << (count + 1))) {
                count++;
            }

            ans += 1 << count;
            dvd -= dvs << count;
        }

        if ((dividend < 0) ^ (divisor < 0)) {
            return -ans;
        }

        return ans;
    }
}
