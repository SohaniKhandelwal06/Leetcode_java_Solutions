//Leetcode-169-Majority Element


/*
Approach:
-> Use the Boyer-Moore Voting Algorithm to find a potential majority element.
1. Initialize count = 0 and candidate.
2. Traverse the array:
   - If count == 0, make the current element the candidate.
   - If the current element equals the candidate, increment count.
   - Otherwise, decrement count.
3. Traverse the array again to count the occurrences of the candidate.
4. If its frequency is greater than n/2, return the candidate; otherwise, return -1.

Time Complexity: O(N) + O(N) = O(N)
Space Complexity: O(1)
*/

class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int el=0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                
                    cnt=1;
                el=nums[i];
            }
            else if(nums[i]==el){
                cnt++;
            }
            else cnt --;
        }
       int  cnt1=0;
        for(int i =0;i<nums.length; i++){
            if(nums[i]==el){
                cnt1++;
            }
        }
            if(cnt1>nums.length/2){
                return el;
            }
              
         return -1;
        
    }
}
