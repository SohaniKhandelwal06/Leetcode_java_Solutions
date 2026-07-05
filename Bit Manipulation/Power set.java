// Leetcode - 78 - Subsets

/*
Approach:
1. There are 2^N possible subsets for an array of size N.
2. Represent each subset using a bitmask from 0 to (2^N - 1).
3. For each bitmask, check every bit:
   - If the ith bit is set, include nums[i] in the current subset.
4. Add the generated subset to the answer.
5. Return all subsets.

Time Complexity: O(N × 2^N)
Space Complexity: O(N) (excluding the output list)
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        int subsets=1<<nums.length;
        for(int i=0;i<subsets;i++){
            List<Integer>list=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))!=0){
list.add(nums[j]);
            }
            }
ans.add(list);
        }
return ans;
    }
}
