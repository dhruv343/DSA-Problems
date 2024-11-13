class Solution {
    int function(int index,int amount,int[] coins,int[][] dp){

        if(index==0){
            if(amount%coins[index]==0){
                return dp[index][amount]=1;
            }
            else return dp[index][amount]=0;
        }
        
        if(dp[index][amount]!=-1) return dp[index][amount];
        
        //not take
        int notTake=function(index-1,amount,coins,dp);
        
        //TAKE
        int take=0;

        if(coins[index]<=amount){
            take=function(index,amount-coins[index],coins,dp);
        }

        return dp[index][amount]=take+notTake;

    }

    public int change(int amount, int[] coins) {
        
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        
        
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return function(n-1,amount,coins,dp);

    }
}