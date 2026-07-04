// Leetcode - 15 - 3Sum

/*
Approach:
1. Sort the array.
2. Traverse the array and fix one element at a time.
3. Use two pointers to find the remaining two elements whose sum equals the negative of the fixed element.
4. Skip duplicate elements to avoid duplicate triplets.
5. Store every unique triplet whose sum is 0.

Time Complexity: O(N²)
Space Complexity: O(1) (excluding the output list)
*/






class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        
        for(int i=0;i<=n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                    
                }
                else if(sum>0){
                    k--;
                }
                else{
                res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                                      
                j++;
                k--;
                while(j<k && nums[j]==nums[j-1]){
                    j++;
                    
                }
                while(j<k && nums[k]==nums[k+1]){
                    k--;
                }
            }
            
        }
        
    }
        return res;
}
}
