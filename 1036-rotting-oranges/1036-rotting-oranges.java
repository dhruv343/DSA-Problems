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
        Queue<Pair> queue=new LinkedList<>();
        boolean[][] visited=new boolean[nRows][nCols];
        int fresh=0;

        for(int i=0;i<nRows;i++){
            for(int j=0;j<nCols;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    queue.add(new Pair(i,j,0));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int[] rows={-1,0,1,0};
        int[] cols={0,1,0,-1};
        int countFresh=0;
        int time=0;

        while(!queue.isEmpty()){
            int r=queue.peek().r;
            int c=queue.peek().c;
            int t=queue.peek().t;
            queue.poll();

            time=Math.max(time,t);

            for(int i=0;i<4;i++){
                int row=r+rows[i];
                int col=c+cols[i];

                if(row>=0 && row<nRows && col>=0 && col<nCols && (visited[row][col]==false) && grid[row][col]==1){
                    countFresh++;
                    visited[row][col]=true;
                    queue.add(new Pair(row,col,t+1));
                }
            }
        }

        if(countFresh!=fresh){
            return -1;
        }

        return time;


    }
}