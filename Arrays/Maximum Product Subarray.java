// Leetcode - 152 - Maximum Product Subarray

/*
Approach:
1. Traverse the array from both left-to-right and right-to-left simultaneously.
2. Maintain prefix and suffix products.
3. If either product becomes 0, reset it to 1 before continuing.
4. At each step, update the maximum product using the current prefix and suffix products.
5. Return the maximum product obtained.

Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    public int maxProduct(int[] nums) {
        int pre=0,suf=0;
        int Maxi=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(pre==0) pre=1;
            if(suf==0) suf=1;
            pre=pre*nums[i];
            suf=suf*nums[n-i-1];
            Maxi=Math.max(Maxi,Math.max(pre,suf));   
        }
        return Maxi;
        
        
    }
}
