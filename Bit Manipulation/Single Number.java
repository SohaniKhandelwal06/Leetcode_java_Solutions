// Leetcode - 136 - Single Number

/*
Approach:
1. Initialize the answer as 0.
2. Traverse the array and XOR every element with the answer.
3. Since x ^ x = 0 and x ^ 0 = x, all duplicate elements cancel out.
4. The remaining value is the element that appears only once.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {
        int XOR=0;
        for(int i=0;i<nums.length;i++){
            XOR=XOR^nums[i];
        }
        return XOR;
    }
}
