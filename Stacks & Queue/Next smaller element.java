// Next Smaller Element

/*
Approach (Monotonic Increasing Stack):
1. Traverse the array from right to left.
2. Remove all elements from the stack that are greater than or equal
   to the current element.
3. If the stack is empty, there is no next smaller element,
   so store -1.
4. Otherwise, the top of the stack is the next smaller element.
5. Push the current element onto the stack.

Time Complexity: O(N)
Space Complexity: O(N)
*/
class Solution {
    public int[] nextSmallerElement(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

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
