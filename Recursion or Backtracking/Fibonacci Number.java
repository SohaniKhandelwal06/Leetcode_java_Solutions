 // Leetcode - 509 - Fibonacci Number

/*
Approach (Recursion):
1. If n is 0 or 1, return n as the base case.
2. Recursively compute the (n-1)th and (n-2)th Fibonacci numbers.
3. Return the sum of the two recursive calls.

Time Complexity: O(2^N)
Space Complexity: O(N) (Recursion Stack)
*/

class Solution {
    public int fib(int n) {
        if(n<=1){
            return n;
            
        }
        return fib(n-1)+fib(n-2);
        
    }
}

