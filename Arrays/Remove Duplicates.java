import java.util.*;

//Leetcode 26-Remove Duplicates from Sorted Array
/*
Approach:
- Use two pointers.
- 'i' keeps track of the last unique element.
- 'j' scans the array.
- When a new unique element is found, place it at index i + 1.

Time Complexity:O(N)
Space Complexity:O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }
}
