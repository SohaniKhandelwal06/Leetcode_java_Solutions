//Leetcode 20 - Valid Parentheses

//
// Approach: Stack
//
// Use a Stack to keep track of opening brackets.
// Whenever a closing bracket is encountered, check whether
// it matches the most recent opening bracket.
//
// If it does not match, return false.
// At the end, the stack must be empty for the parentheses to be valid.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
import java.util.*;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Check closing brackets
            else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // Valid only if no opening bracket remains
        return stack.isEmpty();
    }
}
