// Leetcode - 34 - Find First and Last Position of Element in Sorted Array

/*
Approach (Binary Search):
1. Find the first occurrence using the Lower Bound algorithm.
2. If the target is not present, return {-1, -1}.
3. Find the first index greater than the target using the Upper Bound algorithm.
4. The last occurrence is (Upper Bound - 1).
5. Return the first and last indices.

Time Complexity: O(log N)
Space Complexity: O(1)
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb=lowerbound(nums,target);
if(lb==nums.length || nums[lb]!=target){
return new int[]{-1,-1};
    
    }
        return new int[] {lb,up(nums,target)-1};
}
private int lowerbound(int[]arr,int target){
int low=0;
    int high=arr.length-1;
int ans=arr.length;
    while(low<=high){
int mid=low+(high-low)/2;
if(arr[mid]>=target){
ans=mid;
high=mid-1;
}
        else{
            low=mid+1;
        }
    }
    return ans;
        }
    
    private int up(int[]arr,int target){
int low=0;
    int high=arr.length-1;
int ans=arr.length;
    while(low<=high){
int mid=low+(high-low)/2;
if(arr[mid]>target){
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
    
