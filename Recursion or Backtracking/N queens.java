// Leetcode - 51 - N-Queens

/*
Approach (Recursion + Backtracking):
1. Place one queen in each column.
2. Use three arrays to efficiently track occupied rows, lower diagonals, and upper diagonals.
3. For each row in the current column, check if placing a queen is safe.
4. If safe, place the queen and mark the corresponding row and diagonals as occupied.
5. Recursively place queens in the next column.
6. Once all queens are placed, construct the board configuration and add it to the answer.
7. Backtrack by removing the queen and unmarking the row and diagonals to explore other configurations.

Time Complexity: O(N!)
Space Complexity: O(N²)
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans=new ArrayList<>();
        char[][]board=new char[n][n];
        for(int i=0;i<n;i++){
Arrays.fill(board[i],'.');
        }
        solve(0,board,ans,n);
        return ans;
    }
    private void solve(int row,char[][]board,List<List<String>>ans,int n){
if(row==n){
    ans.add(construct(board));
return;
}
        for(int col=0;col<n;col++){
            
                if(isSafe(row,col,board,n)){
board[row][col]='Q';
                    solve(row+1,board,ans,n);
board[row][col]='.';
                }
                
            }
        }
    private boolean isSafe(int row,int col,char[][]board,int n){
for(int i=row-1;i>=0;i--){
    if(board[i][col]=='Q'){
return false;
    }
}

        
    int i=row-1;
      int  j=col-1;
    while(i>=0 && j>=0){
        if(board[i][j]=='Q'){
return false;
        }
            i--;
            j--;
        
    
    }
        i=row-1;
        j=col+1;
    while(i>=0 && j<n){
        if(board[i][j]=='Q'){
return false;
        }
            i--;
            j++;

                

}
        return true;
    }
    
    private List<String> construct(char[][]board){
        List<String>temp=new ArrayList<>();
        for(char[]row:board){
temp.add(new String(row));

            }
return temp;
        }
}
