// Leetcode - 503 - Next Greater Element II

/*
Approach (Monotonic Decreasing Stack):
1. Since the array is circular, traverse it twice from right to left.
2. Use i % n to access the array circularly.
3. Remove all elements from the stack that are smaller than or equal
   to the current element.
4. During the second half of traversal (i < n):
   - If the stack is empty, the next greater element is -1.
   - Otherwise, the top of the stack is the next greater element.
5. Push the current element onto the stack.

Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer>st=new Stack<>();
        int[]ans=new int[n];
for(int i=2*n-1;i>=0;i--){
    while(!st.isEmpty()&& st.peek()<=nums[i%n]){
st.pop();
}
    if(i<n){
ans[i]=st.isEmpty()?-1:st.peek();        
        
    }
    st.push(nums[i%n]);
}
return ans;
}
}
