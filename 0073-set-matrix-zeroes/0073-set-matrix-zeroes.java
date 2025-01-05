class Solution {
    public void setZeroes(int[][] matrix) {

        int nRows=matrix.length;
        int nCols=matrix[0].length; 
        int[] row=new int[nRows];
        int[] col=new int[nCols];

        for(int i=0;i<nRows;i++){
            for(int j=0;j<nCols;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }


        for(int i=0;i<nRows;i++){
            for(int j=0;j<nCols;j++){
                if(row[i]==1 || col[j]==1){
                   matrix[i][j]=0;
                }
            }
        }

        
    }
}