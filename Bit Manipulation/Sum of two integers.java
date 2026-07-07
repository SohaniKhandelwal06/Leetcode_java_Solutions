// Leetcode - 371 - Sum of Two Integers

/*
Approach:
1. Use XOR to add the bits without considering the carry.
2. Use AND followed by a left shift to compute the carry.
3. Update the first number with the XOR result and the second number with the carry.
4. Repeat until there is no carry left.
5. Return the final sum.

Time Complexity: O(1)
Space Complexity: O(1)
*/






class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
        int carry=(a&b)<<1;
        a=a^b;
        b=carry;
    }
    return a;
        
    }
}
