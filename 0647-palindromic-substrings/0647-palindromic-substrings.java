class Solution {
    public int countSubstrings(String s) {
        
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        

        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }

        for(int i=0;i<n-1;i++){
            
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1]=true;
            }
        }

        for(int len=3;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j=i+len-1;

                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                    dp[i][j]=true;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==true){
                    count++;
                }
            }
        }

        return count;
    }
}