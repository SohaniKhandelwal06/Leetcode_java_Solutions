// Previous Smaller Element

/*
Approach (Monotonic Increasing Stack):
1. Traverse the array from left to right.
2. Remove all elements from the stack that are greater than or equal
   to the current element.
3. If the stack is empty, there is no previous smaller element,
   so store -1.
4. Otherwise, the top of the stack is the previous smaller element.
5. Push the current element onto the stack.

Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    public int[] previousSmallerElement(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return ans;
    }
}
