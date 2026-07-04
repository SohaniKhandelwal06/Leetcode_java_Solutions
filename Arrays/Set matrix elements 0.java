// Leetcode - 73 - Set Matrix Zeroes

/*
Approach:
1. Create two arrays to keep track of the rows and columns that contain a 0.
2. Traverse the matrix and mark the corresponding row and column whenever a 0 is found.
3. Traverse the matrix again and set an element to 0 if its row or column is marked.
4. The matrix is updated in-place based on the marked rows and columns.

Time Complexity: O(M × N)
Space Complexity: O(M + N)
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
     int n=matrix[0].length;
        int col0=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                
                if(j!=0){
                    matrix[0][j]=0;
                }
                else{
                    col0=0;
                    
                }
                
            }
        }
    }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]!=0){
                    if(matrix[i][0]==0||matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if (col0==0){
        for(int i=0;i<m;i++){
                matrix[i][0]=0;
        }
        } 
}
}
