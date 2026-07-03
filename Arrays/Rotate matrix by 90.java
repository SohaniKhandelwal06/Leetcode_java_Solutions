
// Leetcode - 48 - Rotate Image

/*
Approach:
1. Transpose the matrix by swapping matrix[i][j] with matrix[j][i].
2. Reverse every row of the transposed matrix.
3. The matrix is now rotated 90° clockwise in-place.

Time Complexity: O(N²)
Space Complexity: O(1)
*/





class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<=m-2;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<m;i++){
            int left=0;
            int right=n-1;
            while(left<right){
            int temp=matrix[i][left];
            matrix[i][left]=matrix[i][right];
            matrix[i][right]=temp;
            left++;
            right--;
            
        }
    }
}
}
