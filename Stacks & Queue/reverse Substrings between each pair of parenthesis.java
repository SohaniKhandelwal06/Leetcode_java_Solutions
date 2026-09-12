//Leetcode 1190 - Reverse Substrings Between Each Pair of Parentheses

//
// Approach: Stack
//
// Traverse the string and use a stack to store characters.
// When ( is found, push it.
// When ) is found, pop characters until ( is reached,
// reverse that substring, and continue.
//
// Time Complexity:
// O(N²)
//
// Space Complexity: O(N)



class Solution {

    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch != ')') {
                stack.push(ch);
            } 
            else {

                // Store characters inside parentheses
                StringBuilder temp = new StringBuilder();

                while (stack.peek() != '(') {
                    temp.append(stack.pop());
                }

                // Remove '('
                stack.pop();

                // Add reversed substring back
                for (char c : temp.toString().toCharArray()) {
                    stack.push(c);
                }
            }
        }

        // Build final answer
        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}
