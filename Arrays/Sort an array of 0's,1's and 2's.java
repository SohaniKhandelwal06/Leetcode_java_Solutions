// LeetCode 75 - Sort Colors

/*
Approach:
- Use the Dutch National Flag Algorithm.
- Maintain three pointers: low, mid, and high.
- Move 0s to the beginning, 2s to the end, and keep 1s in the middle.
- Traverse the array only once.

Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    public void sortColors(int[] nums) {
    int n=nums.length;
        int low=0;
        int mid=0;
        int high=n-1;
        
            while(mid<=high){
                if(nums[mid]==0){
                    int temp=nums[low];
                    nums[low]=nums[mid];
                    nums[mid]=temp;
                    low++;
                    mid++;
                }
               else if(nums[mid]==1){
                    mid++;
                }
               else{
                 int temp=nums[mid];
                    nums[mid]=nums[high];
                    nums[high]=temp;
                    high--;
                   
               }
            }
        }
    }
