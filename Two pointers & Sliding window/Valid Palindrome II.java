//LeetCode 680 — Valid Palindrome II
/*Approach: Two Pointers + Recursion Check
We are given a string s. We need to determine whether it can become a palindrome after deleting at most one character.

Steps:
1. Initialize two pointers: left = 0 and right = s.length() - 1.
2. Compare characters from both ends.
3. If the characters match, move both pointers inward.
4. If they do not match, try two possibilities:
   - Delete the character at left.
   - Delete the character at right.
5. If either remaining substring is a palindrome, return true.
6. Otherwise, return false.
  */
class Solution {

    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {

                // Try deleting either character
                return isPalindrome(s, left + 1, right) ||
                       isPalindrome(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    // Check whether a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
