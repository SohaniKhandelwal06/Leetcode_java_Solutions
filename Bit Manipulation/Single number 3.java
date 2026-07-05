// Leetcode - 260 - Single Number III

/*
Approach:
1. XOR all the elements to get xor = x ^ y, where x and y are the two unique numbers.
2. Find the rightmost set bit in xor.
3. Divide the elements into two groups based on this set bit.
4. XOR the elements in each group separately.
5. The two XOR results are the required unique numbers.

Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    public int[] singleNumber(int[] nums) {
        long XR=0;
       for(int i=0;i<nums.length;i++){
           XR=XR^nums[i];
       }
           long right=(XR&(XR-1))^(int)XR;
       
       int b1=0;
       int b2=0;
       for(int i=0;i<nums.length;i++){
           if((nums[i] & right)!=0){
               b1=b1^nums[i];
           }
               else{
               b2=b2^nums[i];
               }
           }
       
        return new int[]{b1,b2};
    }
}
