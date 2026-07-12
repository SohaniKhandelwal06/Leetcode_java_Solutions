
// Leetcode - 977 - Squares of a Sorted Array

/*
Approach:
1. Traverse the array and replace each element with its square.
2. After squaring all elements, sort the array in non-decreasing order.
3. Return the sorted array.

Time Complexity: O(N log N)
Space Complexity: O(1) (excluding the space used internally by the sorting algorithm)
*/





class Solution {
    public int[] sortedSquares(int[] nums) {
        int idx=0;
        for(int i=0;i<nums.length;i++){
            nums[idx++]=nums[i]*nums[i];
        }
Arrays.sort(nums);
return nums;        
    }
}
