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

        // int[][] dp = new int[prices.length + 1][2];

        int[] ahead=new int[2];
        int[] curr=new int[2];

        int n = prices.length;

        ahead[0]=ahead[1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                
                int profit;

                if (canBuy == 1) {
                    profit = Math.max(-prices[index] + ahead[0],
                            ahead[1]);
                } else {
                    profit = Math.max(prices[index] + ahead[1],
                             ahead[0]);
                }

                curr[canBuy]=profit;

            }
            System.arraycopy(curr,0,ahead,0,2);
        }

        return ahead[1];

        // for(int[] arr:dp){
        // Arrays.fill(arr,-1);
        // }
        // return function(0,1,prices,dp);
    }
}