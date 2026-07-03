// Leetcode - 53 - Maximum Subarray

/*
Approach:
1. Traverse the array while maintaining the current subarray sum.
2. Add the current element to the running sum.
3. Update the maximum sum obtained so far.
4. If the running sum becomes negative, reset it to 0 since it cannot contribute to a maximum subarray.
5. Return the maximum subarray sum.

Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
maxi=Math.max(maxi,sum);
        
        
if(sum<0){
    sum=0;
}
    }
        return maxi;
        
        
    }
}
