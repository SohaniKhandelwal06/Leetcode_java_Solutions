// Leetcode - 190 - Reverse Bits

/*
Approach:
1. Initialize the answer as 0.
2. Traverse all 32 bits of the given number.
3. Left shift the answer by 1.
4. Extract the least significant bit of the number and add it to the answer.
5. Unsigned right shift the number by 1.
6. Return the reversed bit representation.

Time Complexity: O(32) = O(1)
Space Complexity: O(1)
*/





class Solution {
    public int reverseBits(int n) {
        int ans=0;
        for(int i=0;i<32;i++){
            ans=ans<<1;
            ans=ans|(n&1);
            n=n>>>1;
        }
        return ans;
        
    }
}
