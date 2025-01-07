class Solution {

    int[] rows={-1,0,1,0};
    int[] cols={0,1,0,-1};

    boolean find(char[][] board, String word,int i,int j,int index){

      if(index==word.length()){
        return true;
      }
      if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='$'){
          return false;
      }

      if(board[i][j]!=word.charAt(index)) return false;

      char temp=board[i][j];
      board[i][j]='$';

      for(int q=0;q<4;q++){
        int row=i+rows[q];
        int col=j+cols[q];

        if(find(board,word,row,col,index+1)){
             return true;
        };
      }

      board[i][j]=temp;
      return false;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0) && find(board,word,i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }
}