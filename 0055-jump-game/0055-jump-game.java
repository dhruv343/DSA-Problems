class Solution {

    public boolean f(int[] nums,int ind,int[] dp){
    
    if(ind==nums.length-1){
        return true;
    }
    else if(ind>nums.length-1 || nums[ind]==0){
        return false;
    }

    if(dp[ind]!=-1){
        return dp[ind]==1;
    }

    for(int i=1;i<=nums[ind];i++){
        if(f(nums,ind+i,dp)){
        dp[ind]=1;
        return true;
        }
    }
    
    dp[ind]=0;
    return false;

    }

    public boolean canJump(int[] nums) {
        
        int[] dp=new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return f(nums,0,dp);
    }
}