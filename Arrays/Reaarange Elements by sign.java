// Leetcode - 2149 - Rearrange Array Elements by Sign

/*

Approach:
1. Create an answer array of size n.
2. Initialize pos = 0 and neg = 1.
3. Traverse the given array:
   - If the current element is positive, place it at ans[pos] and increment pos by 2.
   - Otherwise, place it at ans[neg] and increment neg by 2.
4. Return the answer array.

Time Complexity: O(N)
Space Complexity: O(N)
*/




class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int pos=0;
        int neg=1;
        int [] ans=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                ans[neg]=nums[i];
                neg+=2;
            }
            else{
                ans[pos]=nums[i];
                pos+=2;
            }
        }
        return ans;
        
    }
}
