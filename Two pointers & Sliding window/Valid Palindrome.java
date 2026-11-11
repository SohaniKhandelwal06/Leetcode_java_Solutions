//LeetCode 125 — Valid Palindrome
/*Approach: Two Pointers
We need to check whether a string is a palindrome after:
- Converting uppercase letters into lowercase.
- Removing all non-alphanumeric characters.
Steps:
1. Initialize two pointers: left = 0 and right = s.length() - 1.
2. Skip characters that are not letters or digits.
3. Compare the characters at both pointers after converting them to lowercase.
4. If they are different, return false.
5. Move both pointers towards the center.
6. If all characters match, return true.
  */
class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
