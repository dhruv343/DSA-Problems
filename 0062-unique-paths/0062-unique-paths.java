class Solution {
    
    public int function(int i,int j,int[][] dp){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j]=function(i,j-1,dp)+function(i-1,j,dp);
    }

    public int uniquePaths(int m, int n) {
        
        int[][] dp=new int[m][n];

        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return function(m-1,n-1,dp);
        
    }
}