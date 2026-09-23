//Leetcode 989 - Add to Array-Form of Integer

//
// Approach: Simulation + Carry
//
// Start from the last digit of num and the last digit of k.
// Add both digits along with the carry and store the result digit.
// Continue until all digits and the carry are processed.
// Reverse the result because digits are generated from right to left.
//
// Time Complexity:
// O(N + log K)
//
// Space Complexity:
// O(N)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();

        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            int sum = k % 10;
            k /= 10;

            if (i >= 0) {
                sum += num[i--];
            }

            result.add(sum % 10);
            k += sum / 10;
        }

        Collections.reverse(result);
        return result;
    }
}
