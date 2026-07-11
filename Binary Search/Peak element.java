// Leetcode - 162 - Find Peak Element

/*
Approach (Binary Search):
1. Initialize low and high pointers.
2. Find the middle element.
3. Compare nums[mid] with nums[mid + 1]:
   - If nums[mid] > nums[mid + 1], a peak lies in the left half (including mid), so move high = mid.
   - Otherwise, a peak lies in the right half, so move low = mid + 1.
4. Continue until low == high.
5. Return low (or high), which is the index of a peak element.

Time Complexity: O(log N)
Space Complexity: O(1)
*/


class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[n-1]>nums[n-2]){
return n-1;
        }
        int low=1;
        int high=n-2;
        while(low<=high){
int mid=low+(high-low)/2;
if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
    return mid;
}
            else if(nums[mid]>nums[mid+1]){
                high=mid-1;
            }
            else {
low=mid+1;
            }
}
        return -1;
        
    }
}
