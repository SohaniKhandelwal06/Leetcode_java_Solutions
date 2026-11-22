//LeetCode 905 — Sort Array By Parity
/*Approach: Two Pointers
We are given an integer array. We need to rearrange it so that all even numbers appear before odd numbers.

Steps:
1. Initialize two pointers: left = 0 and right = nums.length - 1.
2. If the left element is even, move left forward.
3. If the right element is odd, move right backward.
4. Otherwise, swap the elements at both pointers.
5. Continue until the pointers cross.
*/
class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] % 2 == 0) {
                left++;
            }
            else if (nums[right] % 2 != 0) {
                right--;
            }
            else {
                // Swap even and odd elements
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        return nums;
    }
}
