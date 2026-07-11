// Leetcode - 240 - Search a 2D Matrix II

/*
Approach (Staircase Search):
1. Start from the top-right corner of the matrix.
2. If the current element equals the target, return true.
3. If the current element is greater than the target:
   - Move left since all elements below are even larger.
4. If the current element is less than the target:
   - Move down since all elements to the left are smaller.
5. Continue until the target is found or the indices go out of bounds.
6. If the search ends, return false.

Time Complexity: O(M + N)
Space Complexity: O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int row=0;
        int col=n-1;
        while(row<m && col>=0){
            if(matrix[row][col]==target){
return true;
                
        }
            else if (matrix[row][col]<target){
                row++;
                
            }
            else{
                col--;
            }
        }
        return false;
            }
        
    }
