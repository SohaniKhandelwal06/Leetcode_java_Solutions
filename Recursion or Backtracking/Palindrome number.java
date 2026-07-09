// Palindrome Number (Using Recursion)

/*
Approach (Recursion):
1. If the number is negative, return false.
2. Store the original number in a global variable.
3. Recursively reach the last digit by dividing the number by 10.
4. During backtracking, compare the current digit with the last digit of the original number.
5. Remove the last digit from the original number after each comparison.
6. Return true if all corresponding digits match; otherwise, return false.

Time Complexity: O(log N)
Space Complexity: O(log N) (Recursion Stack)
*/

class Solution {
    int original;

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        original = x;
        return check(x);
    }

    private boolean check(int x) {
        if (x == 0) {
            return true;
        }

        if (!check(x / 10)) {
            return false;
        }

        if (x % 10 != original % 10) {
            return false;
        }

        original /= 10;
        return true;
    }
}
