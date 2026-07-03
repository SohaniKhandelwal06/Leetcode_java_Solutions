
// Leetcode - 560 - Subarray Sum Equals K

/*
Approach:
1. Use a HashMap to store the frequency of prefix sums.
2. Initialize the map with (0, 1) to handle subarrays starting from index 0.
3. Traverse the array and maintain the current prefix sum.
4. If (prefixSum - k) exists in the map, add its frequency to the answer.
5. Store/update the current prefix sum in the HashMap.
6. Return the total count of subarrays.

Time Complexity: O(N)
Space Complexity: O(N)
*/








class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map =new HashMap<>();
        map.put(0,1);
        int ans=0;
        int sum=0;
        for(int j=0;j<nums.length;j++){
            sum=sum+nums[j];
            if(map.containsKey(sum-k)){
                ans=ans+map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
                       
            }
            else{
                map.put(sum,1);
            }
        }
        return ans;
    }
}
