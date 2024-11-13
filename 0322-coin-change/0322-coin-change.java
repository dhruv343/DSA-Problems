class Solution {

    int function(int index, int amount, int[] coins, int[][] dp) {

        if (index == 0) {
            if (amount % coins[index] == 0) {
                return dp[index][amount] = amount / coins[index];
            } else
                return dp[index][amount] = (int) 1e9;
        }

        if (dp[index][amount] != -1)
            return dp[index][amount];

        // not take
        int notTake = 0 + function(index - 1, amount, coins, dp);

        // TAKE
        int take = Integer.MAX_VALUE;

        if (coins[index] <= amount) {
            take = 1 + function(index, amount - coins[index], coins, dp);
        }

        return dp[index][amount] = Math.min(take, notTake);

    }

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        // int[][] dp = new int[n][amount + 1];
        int[] prev=new int[amount+1];
        int[] curr=new int[amount+1];

        // base case
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = i / coins[0];
            } else {
                prev[i] = (int) 1e9;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int amt = 0; amt <= amount; amt++) {

                // not take
                int notTake = 0 + prev[amt];

                // TAKE
                int take = Integer.MAX_VALUE;

                if (coins[index] <= amt) {
                    take = 1 + curr[amt-coins[index]];
                }

                curr[amt] = Math.min(take, notTake);
            }

            System.arraycopy(curr,0,prev,0,amount+1);
        }



        // for(int[] arr:dp){
        // Arrays.fill(arr,-1);
        // }

        int ans=prev[amount];

        if(ans>=1e9){
        return -1;
        }
        else return ans;

    }
}