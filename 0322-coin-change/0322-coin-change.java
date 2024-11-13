class Solution {

    int function(int index,int amount,int[] coins,int[][] dp){

        if(index==0){
            if(amount%coins[index]==0){
                return dp[index][amount]=amount/coins[index];
            }
            else return dp[index][amount]=(int) 1e9;
        }
        
        if(dp[index][amount]!=-1) return dp[index][amount];
        
        //not take
        int notTake=0+function(index-1,amount,coins,dp);
        
        //TAKE
        int take=Integer.MAX_VALUE;

        if(coins[index]<=amount){
            take=1+function(index,amount-coins[index],coins,dp);
        }

        return dp[index][amount]=Math.min(take,notTake);

    }
    public int coinChange(int[] coins, int amount) {

        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        int ans=function(n-1,amount,coins,dp);

        if(ans>=1e9){
            return -1;
        }
        else return ans;

    }
}