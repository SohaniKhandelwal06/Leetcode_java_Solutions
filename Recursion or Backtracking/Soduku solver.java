// Leetcode - 37 - Sudoku Solver

/*
Approach (Recursion + Backtracking):
1. Traverse the Sudoku board to find the first empty cell ('.').
2. Try placing digits '1' to '9' in the empty cell.
3. Check if the digit is valid by ensuring it does not already exist in the current row, column, or 3×3 subgrid.
4. If the placement is valid, recursively solve the remaining board.
5. If no valid digit leads to a solution, backtrack by resetting the cell to '.'.
6. Continue until all cells are filled, producing the solved Sudoku.

Time Complexity: O(9^(N²)) (Worst Case)
Space Complexity: O(N²) (Recursion Stack)
*/









class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
        
    }
    private boolean solve(char[][]board){
        int n=board.length;
for(int i=0;i<9;i++){
    for(int j=0;j<9;j++){
        if(board[i][j]=='.'){
            for(char ch='1';ch<='9';ch++){
                if(isValid(board,i,j,ch)){
board[i][j]=ch;
                    if(solve(board)==true){
return true;
                    }
                    board[i][j]='.';
                    
                    }
            }
            return false;
        }
    }
}
return true;
}
    private boolean isValid(char[][]board,int row,int col,char ch){
for(int i=0;i<9;i++){
    if(board[row][i]==ch){
return false;
    }
    if(board[i][col]==ch){
return false;
    }
if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch){
return false;
}
}
        
    return true;
    
}
}
