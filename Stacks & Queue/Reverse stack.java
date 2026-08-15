// Reverse a Stack using Recursion
//
// Approach:
// 1. Pop the top element.
// 2. Recursively reverse the remaining stack.
// 3. Insert the popped element at the bottom.
//
// Time Complexity: O(N^2)
// Space Complexity: O(N)

class Solution {

    public void Reverse(Stack<Integer> st) {

        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();

        Reverse(st);

        insertAtBottom(st, top);
    }

    private void insertAtBottom(
            Stack<Integer> st,
            int value) {

        if (st.isEmpty()) {
            st.push(value);
            return;
        }

        int top = st.pop();

        insertAtBottom(st, value);

        st.push(top);
    }
}
