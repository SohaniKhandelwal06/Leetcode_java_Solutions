// Leetcode - 85 - Maximal Rectangle

/*
Approach:
1. Treat each row as the base of a histogram.
2. Maintain a heights[] array:
   - If matrix[i][j] == '1', increment heights[j].
   - Otherwise, reset heights[j] = 0.
3. For each row, compute the largest rectangle area in the
   histogram using a monotonic increasing stack.
4. Keep track of the maximum area across all rows.

Time Complexity:
- Building heights: O(N × M)
- Largest Rectangle for each row: O(M)
Overall: O(N × M)

Space Complexity:
O(M)
*/
class Solution {
    private int largestRectangleArea(int[]arr){
        Stack<Integer>st=new Stack<>();
        int maxArea=0;
        int n=arr.length;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() &&(i==n || arr[st.peek()]>=arr[i])){
int h=arr[st.pop()];
                int right=i;
                int left=st.isEmpty()?-1:st.peek();
                int width=right-left-1;
                maxArea=Math.max(maxArea, h*width);
        }
            if(i<n){
st.push(i);
    }
        }
return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[]h=new int[n];
int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    h[j]++;
                }
else{
    h[j]=0;
}
            }
ans=Math.max(ans,largestRectangleArea(h));
}
                
return ans;
            }
        }
        
        
    
