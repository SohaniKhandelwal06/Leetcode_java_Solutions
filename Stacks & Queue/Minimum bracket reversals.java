// Minimum Bracket Reversals
//
// Approach: Stack
//
// A reversal changes:
// '{' -> '}'
// '}' -> '{'
//
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    int countMinReversals(String s) {

        int n = s.length();

        // Odd length cannot be balanced
        if (n % 2 != 0) {
            return -1;
        }

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '{') {

                st.push(ch);

            } else {

                if (!st.isEmpty() &&
                    st.peek() == '{') {

                    st.pop();

                } else {

                    st.push(ch);
                }
            }
        }

        int open = 0;
        int close = 0;

        // Count remaining unmatched brackets
        while (!st.isEmpty()) {

            if (st.pop() == '{') {
                open++;
            } else {
                close++;
            }
        }

        // ceil(open / 2) + ceil(close / 2)
        return (open + 1) / 2 +
               (close + 1) / 2;
    }
}
