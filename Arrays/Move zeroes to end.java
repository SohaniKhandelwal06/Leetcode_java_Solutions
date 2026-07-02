//Leetcode -283 -Move Zeroes


/*

Approach:
1. Find the first zero in the array.
2. If no zero exists, return.
3. Traverse from j + 1.
4. If nums[i] is non-zero:
   - Swap nums[i] and nums[j].
   - Increment j.

Time Complexity: O(N)
Space Complexity: O(1)
*/



class Solution {
    public void moveZeroes(int[] nums) {
        int j=-1;
        for(int i =0; i<nums.length;i++){
            if (nums[i]==0){
                j=i;
                break;
            }
        }
        if(j == -1) {return ;}
        for(int i=j+1;i<nums.length;i++){
            if (nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                    
                j++;
            }
        }
        
        
    }
}
