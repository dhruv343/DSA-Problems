class Solution {

    public void dfs(int row,int col,int[][] grid,boolean[][] visited){
    if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]!=1 || visited[row][col]==true){
        return;
    }
    
    visited[row][col]=true;

    dfs(row-1,col,grid,visited);
    dfs(row,col+1,grid,visited);
    dfs(row+1,col,grid,visited);
    dfs(row,col-1,grid,visited);

    }
    public int numEnclaves(int[][] grid) {
        
        int nRows=grid.length;
        int nCols=grid[0].length;
        boolean [][] visited=new boolean[nRows][nCols];
        

        for(int i=0;i<nCols;i++){
            if(!visited[0][i] && grid[0][i]==1){
            dfs(0,i,grid,visited);
            }
        }

        for(int i=0;i<nCols;i++){
            if(!visited[nRows-1][i] && grid[nRows-1][i]==1){
            dfs(nRows-1,i,grid,visited);
            }
        }

        for(int i=0;i<nRows;i++){
            if(!visited[i][0] && grid[i][0]==1){
            dfs(i,0,grid,visited);
            }
        }

        for(int i=0;i<nRows;i++){
            if(!visited[i][nCols-1] && grid[i][nCols-1]==1){
            dfs(i,nCols-1,grid,visited);
            }
        }
        
        int count=0;

        for(int i=0;i<nRows;i++){
            for(int j=0;j<nCols;j++){
                if(grid[i][j]==1 &&  visited[i][j]==false){
                    count++;
                }
            }
        }
        return count;
    }
}