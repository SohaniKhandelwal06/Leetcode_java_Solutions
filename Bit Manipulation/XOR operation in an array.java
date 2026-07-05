// Leetcode - 1486 - XOR Operation in an Array

/*
Approach:
1. Initialize the answer as 0.
2. Traverse from 0 to n - 1.
3. Generate each element using the formula:
   element = start + 2 * i.
4. XOR each generated element with the answer.
5. Return the final XOR value.

Time Complexity: O(N)
Space Complexity: O(1)
  */


class Solution {
    public int xorOperation(int n, int start) {
        int res=0;
        for(int i=0;i<n;i++){
            res=res^start+2*i;
        }
        return res;
        
        
    }
}
