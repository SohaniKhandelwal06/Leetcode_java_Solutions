

// Leetcode - 31 - Next Permutation

/*
Approach:
1. Traverse the array from right to left and find the first index 'i' such that nums[i] < nums[i + 1].
2. If such an index exists, traverse again from the end to find the first element greater than nums[i] and swap them.
3. Reverse the subarray from i + 1 to the end.
4. If no such index exists, reverse the entire array to obtain the smallest permutation.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    void reverse(int arr[],int start,int end){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) { int idx=-1;
        int n=nums.length;                            for(int i=n-2; i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
                   if(idx==-1){
                                                 reverse(nums,0,n-1);
             return;                                }
                                             for(int i=n-1;i>idx;i--){
                                                 if(nums[i]>nums[idx]){
                                                     int temp=nums[i];
                                                     nums[i]=nums[idx];
                                                     nums[idx]=temp;
                break;                                 }
                                             }
                                             reverse(nums,idx+1,n-1);
        
    }
}
