class Solution {
    
    public String longestPalindrome(String s) {

        int length=s.length();
        boolean[][] dp=new boolean[length][length];
        int maxLen=0;
        int start=0;

        if(length==0){
            return "";
        }
        for(int i=0;i<length;i++){
            dp[i][i]=true;
            maxLen=1;
        }

        for(int i=0;i<length-1;i++){
        if(s.charAt(i)==s.charAt(i+1)){
            dp[i][i+1]=true;
            start=i;
            maxLen=2;
        }
        }

        

        for(int len=3;len<=length;len++){
            for(int i=0;i<length-len+1;i++){
                int j=i+len-1;

                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                    dp[i][j]=true;

                    if(len>maxLen){
                        maxLen=len;
                        start=i;
                    }
                }
            }
        }
        
        return s.substring(start,start+maxLen);

    }
}