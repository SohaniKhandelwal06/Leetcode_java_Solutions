//Leetcode 1020 - Number of Enclaves
//
// Approach: Boundary BFS
//
// - Any land cell connected to the boundary is not an enclave.
// - Start BFS from all boundary land cells.
// - Mark all land cells connected to the boundary as visited.
// - Finally, count the remaining unvisited land cells.
//
// Time Complexity: O(M * N)
// Space Complexity: O(M * N)












class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
        
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]vis=new int[m][n];
        for(int i=0;i<m;i++){
            if(grid[i][0]==1 && vis[i][0]==0){
bfs(i,0,grid,vis);
            }
if(grid[i][n-1]==1 && vis[i][n-1]==0){
bfs(i,n-1,grid,vis);
}
        }
for(int j=0;j<n;j++){
    if(grid[0][j]==1 && vis[0][j]==0){
bfs(0,j,grid,vis);
            }
    if(grid[m-1][j]==1 && vis[m-1][j]==0){
bfs(m-1,j,grid,vis);
            }
    
}
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void bfs(int row,int col,int[][]grid,int[][]vis){
int m=grid.length;
    int n=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(row,col));
vis[row][col]=1;
int[]dr={-1,1,0,0};
        int[]dc={0,0,-1,1};
        while(!q.isEmpty()){
            Pair temp=q.poll();
            row=temp.first;
             col=temp.second;
            for(int k=0;k<4;k++){
                int nrow=row+dr[k];
int ncol=col+dc[k];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }
    }
                }

            
        
            
        

        
    
