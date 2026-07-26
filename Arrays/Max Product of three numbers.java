
// Leetcode 628 - Maximum Product of Three Numbers

/*
Approach (Sorting)

- Sort the array.
- The three largest numbers are:
      nums[n-1], nums[n-2], nums[n-3]

- The two smallest numbers and the largest number are:
      nums[0], nums[1], nums[n-1]

The maximum product is the maximum of these two possibilities.

Time Complexity: O(N log N)

Space Complexity: O(1)
excluding sorting space.
*/








class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
int n=nums.length;
int i=nums[n-1]*nums[n-2]*nums[n-3];
int j=nums[0]*nums[1]*nums[n-1];
return Math.max(i,j);
    }
}
        
