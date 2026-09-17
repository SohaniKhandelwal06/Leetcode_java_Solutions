//Leetcode 32 - Longest Valid Parentheses

//
// Approach: Stack
//
// Use a stack to store indices of unmatched parentheses.
// Push -1 initially as a base index.
// For an opening (, push its index.
// For a closing ), pop the stack.
// If the stack becomes empty, push the current index as the new base.
// Otherwise, the length of the current valid substring is
// i - stack.peek().
// Keep track of the maximum length.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
import java.util.*;

class Solution {

    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Base index before the current valid substring
        stack.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                // Store index of opening bracket
                stack.push(i);

            } else {

                // Match the closing bracket
                stack.pop();

                // No matching opening bracket
                if (stack.isEmpty()) {

                    // Current index becomes new base
                    stack.push(i);

                } else {

                    // Length of valid parentheses substring
                    maxLen = Math.max(
                        maxLen,
                        i - stack.peek()
                    );
                }
            }
        }

        return maxLen;
    }
}
