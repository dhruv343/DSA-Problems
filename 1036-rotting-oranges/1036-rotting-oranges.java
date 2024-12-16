class Solution {
    class Pair{
        int r;
        int c;
        int t;

        Pair(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        
        int nRows=grid.length;
        int nCols=grid[0].length;
        int[][] visited=new int[nRows][nCols];
        Queue<Pair> queue=new LinkedList<>();
        int cntFresh=0;
        int time=0;

        for(int i=0;i<nRows;i++){
            for(int j=0;j<nCols;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }
                else if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }
        
        int count=0;
        int[] rows={-1,0,1,0};
        int[] cols={0,1,0,-1};

        while(!queue.isEmpty()){
            int r=queue.peek().r;
            int c=queue.peek().c;
            int t=queue.peek().t;
            queue.poll();

            time=Math.max(t,time);

            for(int i=0;i<4;i++){
                int row=r+rows[i];
                int col=c+cols[i];

                while(row>=0 && row<nRows && col>=0 && col<nCols && visited[row][col]==0 && grid[row][col]==1){
                    visited[row][col]=1;
                    count++;
                    queue.add(new Pair(row,col,t+1));
                }
            }
        }

        if(cntFresh!=count){
            return -1;
        }

        return time;
    }
}