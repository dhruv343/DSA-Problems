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
        

        int prev=nums[0];
        int prev1=0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i]+prev1;
            
            int notPick = prev;

            int curr = Math.max(pick, notPick);
            prev1=prev;
            prev=curr;
        }

        return prev;

        // Arrays.fill(dp,-1);
        // return func(n-1,dp,nums);
    }
}