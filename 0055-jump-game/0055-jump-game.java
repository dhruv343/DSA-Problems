class Solution {

    public boolean f(int[] nums,int ind,int[] dp){
    
    if(ind==nums.length-1){
        return true;
    }
    else if(ind>nums.length-1){
        return false;
    }
    else if(nums[ind]==0){
        return false;
    }

    if(dp[ind]!=-1){
        if(dp[ind]==1){
            return true;
        }
        else{
            return false;
        }
    }

    boolean cal=false;

    for(int i=1;i<=nums[ind];i++){
        cal=cal || f(nums,ind+i,dp);
    }
    
    if(cal==true){
        dp[ind]=1;
        return true;
    }
    else{
        dp[ind]=0;
        return false;
    }

    }

    public boolean canJump(int[] nums) {
        
        int[] dp=new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return f(nums,0,dp);
    }
}