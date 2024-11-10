class Solution {

    public int f(int n,int m,String s1,String s2,int[][] dp){
       
       if(n==0 || m==0){
        return 0;
       }
       if(dp[n][m]!=-1) return dp[n][m];

       if(s1.charAt(n-1)==s2.charAt(m-1)){
        return dp[n][m]=1+f(n-1,m-1,s1,s2,dp);
       }

       return dp[n][m]=0 + Math.max(f(n-1,m,s1,s2,dp),f(n,m-1,s1,s2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        return f(n,m,text1,text2,dp);
    }
}