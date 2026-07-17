// Find Missing and Repeating Number

/*
Approach (Mathematics):

Let:
x = Repeating number
y = Missing number

Expected Sum:
SN = n * (n + 1) / 2

Expected Sum of Squares:
S2N = n * (n + 1) * (2n + 1) / 6

Actual Sum = S
Actual Sum of Squares = S2

Equation 1:
x - y = S - SN

Equation 2:
x² - y² = S2 - S2N

=> (x - y)(x + y) = S2 - S2N

So,
x + y = (S2 - S2N) / (x - y)

Finally,

Repeating = ( (x - y) + (x + y) ) / 2

Missing = (x + y) - Repeating

Time Complexity: O(N)
Space Complexity: O(1)
*/







class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;

        long SN = (long) n * (n + 1) / 2;
        long S2N = (long) n * (n + 1) * (2 * n + 1) / 6;

        long S = 0;
        long S2 = 0;

        for (int num : nums) {
            S += num;
            S2 += (long) num * num;
        }

        long val1 = S - SN;          // x - y
        long val2 = (S2 - S2N) / val1; // x + y

        long repeating = (val1 + val2) / 2;
        long missing = val2 - repeating;

        return new int[]{(int) repeating, (int) missing};
    }
}
