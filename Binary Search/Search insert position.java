// Leetcode - 35 - Search Insert Position

/*
Approach (Binary Search):
1. Initialize low = 0, high = n - 1, and ans = n.
2. Find the middle element.
3. If nums[mid] >= target:
   - Store mid as a possible insertion position.
   - Continue searching in the left half for an earlier valid position.
4. Otherwise, search in the right half.
5. Return the stored answer. If the target is greater than all elements, return n.

Time Complexity: O(log N)
Space Complexity: O(1)
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
int ans=nums.length;
        while(low<=high){
int mid=low+(high-low)/2;
            if(nums[mid]>=target){
ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        
    }
        return ans;
}
}
