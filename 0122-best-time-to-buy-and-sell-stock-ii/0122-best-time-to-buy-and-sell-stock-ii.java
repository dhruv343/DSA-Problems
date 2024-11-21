class Solution {

    public int function(int index, int canBuy, int[] prices, int[][] dp) {

        if (index == prices.length) {
            return 0;
        }

        if (dp[index][canBuy] != -1)
            return dp[index][canBuy];

        int profit;

        if (canBuy == 1) {
            profit = Math.max(-prices[index] + function(index + 1, 0, prices, dp), function(index + 1, 1, prices, dp));
        } else {
            profit = Math.max(prices[index] + function(index + 1, 1, prices, dp), function(index + 1, 0, prices, dp));
        }

        return dp[index][canBuy] = profit;
    }

    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length + 1][2];

        int n = prices.length;

        dp[n][0] = dp[n][1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                
                int profit;

                if (canBuy == 1) {
                    profit = Math.max(-prices[index] + dp[index+1][0],
                            dp[index+1][1]);
                } else {
                    profit = Math.max(prices[index] + dp[index+1][1],
                             dp[index+1][0]);
                }

                dp[index][canBuy] = profit;

            }
        }

        return dp[0][1];

        // for(int[] arr:dp){
        // Arrays.fill(arr,-1);
        // }
        // return function(0,1,prices,dp);
    }
}