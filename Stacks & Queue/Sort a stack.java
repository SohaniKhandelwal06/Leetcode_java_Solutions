// Sort a Stack using Recursion
//
// Approach:
// 1. Pop the top element.
// 2. Recursively sort the remaining stack.
// 3. Insert the popped element at its correct position.
//
// Time Complexity: O(N^2)
// Space Complexity: O(N)

class Solution {

    public void sortStack(Stack<Integer> st) {

        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();

        sortStack(st);

        insert(st, top);
    }

    private void insert(
            Stack<Integer> st,
            int value) {

        // Correct position found
        if (st.isEmpty() ||
            st.peek() <= value) {

            st.push(value);
            return;
        }

        int top = st.pop();

        insert(st, value);

        st.push(top);
    }
}
