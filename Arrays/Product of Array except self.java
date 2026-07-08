// Leetcode - 238 - Product of Array Except Self

/*
Approach (Prefix and Suffix Product):
1. Create an answer array to store the prefix products.
2. Traverse from left to right and store the product of all elements before the current index.
3. Maintain a suffix product while traversing from right to left.
4. Multiply the prefix product with the suffix product for each index.
5. Return the final answer array.

Time Complexity: O(N)
Space Complexity: O(1) (excluding the output array)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int []ans=new int[n];
ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
int suffix=1;
        for(int i=n-1;i>=0;i--){
            ans[i]=ans[i]*suffix;
            suffix=suffix*nums[i];
        }
        return ans;
    }
}
