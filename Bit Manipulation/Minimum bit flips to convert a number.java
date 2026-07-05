// Leetcode - 2220 - Minimum Bit Flips to Convert Number

/*
Approach:
1. Perform XOR between start and goal.
2. The set bits in the XOR result represent the bits that differ.
3. Count the number of set bits using Brian Kernighan's algorithm.
4. Return the count as the minimum number of bit flips required.

Time Complexity: O(Number of Set Bits)
Space Complexity: O(1)
*/


class Solution {
    public int minBitFlips(int start, int goal) {
        int ans=start^goal;
        int cnt=0;
        while(ans!=0){
            ans=ans & (ans-1);
cnt++;
        }
        return cnt;
        
    }
}
