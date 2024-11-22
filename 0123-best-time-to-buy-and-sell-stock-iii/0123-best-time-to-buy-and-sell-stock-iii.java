class Solution {

    public int function(int index, int canBuy, int cap, int[] prices, int[][][] dp) {
        if (index == prices.length || cap == 0) {
            return 0;
        }
        
        if(dp[index][canBuy][cap]!=-1) return dp[index][canBuy][cap];
        int profit;
        if (canBuy == 1) {
            profit = Math.max(-prices[index] + function(index + 1, 0, cap, prices,dp),
                    function(index + 1, 1, cap, prices,dp));
        } else {
            profit = Math.max(prices[index] + function(index + 1, 1, cap - 1, prices,dp),
                    function(index + 1, 0, cap, prices,dp));
        }

        return dp[index][canBuy][cap] = profit;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return function(0, 1, 2, prices, dp);
    }
}