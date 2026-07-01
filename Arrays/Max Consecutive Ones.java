// LeetCode 485 - Max Consecutive Ones

/*
Approach:
- Traverse the array once.
- Count consecutive 1s.
- Reset the count when a 0 is encountered.
- Keep track of the maximum count.

Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
intmaxi=0;
int cnt=0;
 for(int i=0;i<nums.length;i++){
     if(nums[i]==1){
         cnt++;
maxi=Math.max(maxi,cnt);
                                                     
}
                                                     
else {
cnt=0;
}
                                                      
}
                                                  
return maxi;
                                                 
}
        
    }
