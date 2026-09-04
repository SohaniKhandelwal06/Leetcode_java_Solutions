// Leetcode 728 - Self Dividing Numbers
//
// A number is self-dividing if:
// 1. It contains no digit 0.
// 2. It is divisible by every digit.
//
// Time Complexity: O(N * D)
// Space Complexity: O(1) excluding answer

class Solution {

    public List<Integer> selfDividingNumbers(
            int left,
            int right) {

        List<Integer> ans =
            new ArrayList<>();

        for (int num = left;
             num <= right;
             num++) {

            if (isSelfDividing(num)) {
                ans.add(num);
            }
        }

        return ans;
    }

    private boolean isSelfDividing(int num) {

        int temp = num;

        while (temp > 0) {

            int digit = temp % 10;

            // Digit 0 cannot divide a number
            if (digit == 0) {
                return false;
            }

            if (num % digit != 0) {
                return false;
            }

            temp /= 10;
        }

        return true;
    }
}
