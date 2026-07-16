// Leetcode - 84 - Largest Rectangle in Histogram

/*
Approach (Monotonic Increasing Stack):
1. Maintain a stack storing indices of bars in increasing height.
2. Traverse the histogram from left to right.
3. Whenever the current bar is smaller than the stack's top,
   pop the top bar and calculate the rectangle formed using it.
4. For the popped bar:
   - Height = heights[poppedIndex]
   - Right= current index (i)
   - Left= stack top after popping (or -1 if empty)
   - Width = NSE - PSE - 1
   - Area = Height × Width
5. Continue until the stack becomes increasing again.
6. Traverse until i = n (dummy iteration) to process all remaining bars.

Time Complexity: O(N)
Space Complexity: O(N)
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer>st=new Stack<>();
      int  maxArea=0;
        for(int i=0;i<=n;i++){
        while(!st.isEmpty()&&(i==n || heights[st.peek()]>=heights[i])){
            int h=heights[st.pop()];
            int right=i;
            int left=st.isEmpty()?-1:st.peek();
            int width=right-left-1;
            maxArea=Math.max(maxArea,h*width);
        }
st.push(i);

        
    }
return maxArea;
}
}
