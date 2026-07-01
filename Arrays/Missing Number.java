//Leetcode-268-Missing Number
/*
Approach:
- Calculate the expected sum of numbers from 0 to n.
- Calculate the actual sum of the array elements.
- The difference between the expected sum and the actual sum is the missing number.

Time Complexity:O(N)
  Space Complexity:O(1)
  */


class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0;
        int s=n*(n+1)/2;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
        }
        return (s-sum);
        
    }
}
