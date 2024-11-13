class Solution {
    int function(int index, int amount, int[] coins, int[][] dp) {

        if (index == 0) {
            if (amount % coins[index] == 0) {
                return dp[index][amount] = 1;
            } else
                return dp[index][amount] = 0;
        }

        if (dp[index][amount] != -1)
            return dp[index][amount];

        // not take
        int notTake = function(index - 1, amount, coins, dp);

        // TAKE
        int take = 0;

        if (coins[index] <= amount) {
            take = function(index, amount - coins[index], coins, dp);
        }

        return dp[index][amount] = take + notTake;

    }

    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = 1;
            } else
                prev[i] = 0;
        }

        for (int index = 1; index < n; index++) {
            for (int amt = 0; amt <= amount; amt++) {
                int notTake = prev[amt];
                // TAKE
                int take = 0;

                if (coins[index] <= amt) {
                    take = curr[amt - coins[index]];
                }

                curr[amt] = take + notTake;
            }
            System.arraycopy(curr,0,prev,0,amount+1);
        }

        return prev[amount];
        // for(int[] arr:dp){
        // Arrays.fill(arr,-1);
        // }

        // return function(n-1,amount,coins,dp);

    }
}