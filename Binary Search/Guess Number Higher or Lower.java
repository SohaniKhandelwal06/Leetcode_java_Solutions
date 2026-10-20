//Leetcode 374 - Guess Number Higher or Lower
//
// Approach: Binary Search
//
// Search for the target number between 1 and n.
// Calculate the middle value and call guess(mid).
// If the result is 0, the number is found.
// If the result is -1, search the left half; otherwise, search the right half.
//
// Time Complexity:
// O(log N)
//
// Space Complexity:
// O(1)
/**
 * Forward declaration of guess API.
 * @param num Your guess
 * @return -1 if num is higher than the picked number,
 *          1 if num is lower than the picked number,
 *          0 if num is equal to the picked number
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
