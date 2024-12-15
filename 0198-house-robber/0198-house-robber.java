class Solution {

    int func(int n, int[] dp, int[] arr) {

        if (n == 0)
            return arr[0];
        if (n < 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int pick = arr[n] + func(n - 2, dp, arr);
        int notPick = func(n - 1, dp, arr);

        return dp[n] = Math.max(pick, notPick);
    }

    public int rob(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        

        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            
            if(i>1){
                pick+=dp[i-2];
            }

            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];

        // Arrays.fill(dp,-1);
        // return func(n-1,dp,nums);
    }
}