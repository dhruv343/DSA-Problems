class Solution {

    public boolean f(int index, int target, int[] nums, int[][] dp) {

        if (target == 0)
            return true;
        if (index == 0)
            return nums[0] == target;

        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }

        // not take
        boolean notTake = f(index - 1, target, nums, dp);

        // take
        boolean take = false;
        if (nums[index] <= target) {
            take = f(index - 1, target - nums[index], nums, dp);
        }

        if (take || notTake) {
            dp[index][target] = 1;
            return true;
        }
        dp[index][target] = 0;
        return false;

    }

    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int i:nums){
            sum+=i;
        }

        int target=sum/2;
        int n=nums.length;
        if(sum%2!=0) return false;
        
        boolean[][] dp=new boolean[n][target+1];
        for(boolean[] arr:dp){
        Arrays.fill(arr,false);
        }
        
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=target){
            dp[0][nums[0]]=true;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
             //not take
            boolean notTake=dp[i-1][j];

            //take
            boolean take=false;
            if(nums[i]<=j){
                take=dp[i-1][j-nums[i]];
            }

            dp[i][j]=take || notTake;
            }
        }

        return dp[n-1][target];

    }
}