// Leetcode - 89 - Gray Code

/*
Approach:
1. There are 2^n Gray codes for n bits.
2. Traverse all numbers from 0 to (2^n - 1).
3. Convert each number to its Gray code using:
   gray = i ^ (i >> 1)
4. Add each Gray code to the answer list.
5. Return the generated Gray code sequence.

Time Complexity: O(2^N)
Space Complexity: O(1) (excluding the output list)
*/

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            ans.add(i^(i>>1));
        }
return ans;
    }
}
