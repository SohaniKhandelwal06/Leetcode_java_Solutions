// Leetcode - 74 - Search a 2D Matrix

/*
Approach (Binary Search):
1. Treat the 2D matrix as a flattened sorted array of size m × n.
2. Perform binary search on indices from 0 to (m × n - 1).
3. Convert the 1D index to 2D coordinates:
      row = mid / numberOfColumns
      col = mid % numberOfColumns
4. Compare the matrix element with the target.
5. If equal, return true.
6. If the target is larger, search the right half; otherwise, search the left half.
7. If the search space becomes empty, return false.

Time Complexity: O(log(M × N))
Space Complexity: O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high){
int mid=low+(high-low)/2;
            int row=mid/n;
            int col=mid%n;
            if(matrix[row][col]==target){
return true;
            }
            else if(matrix[row][col]<target){
low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
        
        
            }
        
    }



