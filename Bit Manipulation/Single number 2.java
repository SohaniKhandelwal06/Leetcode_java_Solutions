// Leetcode - 137 - Single Number II

/*
Approach:
1. Maintain two bitmasks:
   - ones stores bits that have appeared once.
   - twos stores bits that have appeared twice.
2. For each number:
   - Update ones by XORing the number and removing bits already present in twos.
   - Update twos by XORing the number and removing bits already present in ones.
3. Bits appearing three times are automatically cleared from both masks.
4. After processing all numbers, ones contains the unique element.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {
        int ones=0;
        int twos=0;
        for(int i=0;i<nums.length;i++){
            ones=ones^nums[i] & (~twos);
            twos=twos^nums[i] & (~ones);
        }
        return ones;
        
    }
}
