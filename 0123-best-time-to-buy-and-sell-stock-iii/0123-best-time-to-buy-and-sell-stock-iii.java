class Solution {

    public int function(int index, int canBuy, int cap, int[] prices, int[][][] dp) {
        if (index == prices.length || cap == 0) {
            return 0;
        }

        if (dp[index][canBuy][cap] != -1)
            return dp[index][canBuy][cap];
        int profit;
        if (canBuy == 1) {
            profit = Math.max(-prices[index] + function(index + 1, 0, cap, prices, dp),
                    function(index + 1, 1, cap, prices, dp));
        } else {
            profit = Math.max(prices[index] + function(index + 1, 1, cap - 1, prices, dp),
                    function(index + 1, 0, cap, prices, dp));
        }

        return dp[index][canBuy][cap] = profit;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        // for (int i = 0; i <= 1; i++) {
        //     for (int j = 0; j <= 2; j++) {
        //         dp[n][i][j] = 0;
        //     }
        // }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j <= 1; j++) {
        //         dp[i][j][0] = 0;
        //     }
        // }

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    
                    int profit;
                    if (canBuy == 1) {
                        profit = Math.max(-prices[index] + dp[index + 1][0][cap],
                                dp[index + 1][1][cap]);
                    } else {
                        profit = Math.max(prices[index] + dp[index + 1][1][cap-1],
                               dp[index + 1][0][cap]);
                    }

                    dp[index][canBuy][cap] = profit;
                }
            }
        }

        return dp[0][1][2];

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < 2; j++) {
        // for (int k = 0; k < 3; k++) {
        // dp[i][j][k] = -1;
        // }
        // }
        // }
        // return function(0, 1, 2, prices, dp);
    }
}