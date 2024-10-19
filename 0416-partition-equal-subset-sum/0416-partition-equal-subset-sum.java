class Solution {

    public boolean f(int index,int target,int[] nums,int[][] dp){
    
    if(target==0) return true;
    if(index==0) return nums[0]==target;
    
    if(dp[index][target]!=-1){
    return dp[index][target]==0?false:true;
    }

    //not take
    boolean notTake=f(index-1,target,nums,dp);

    //take
    boolean take=false;
    if(nums[index]<=target){
        take=f(index-1,target-nums[index],nums,dp);
    }

    if(take || notTake){
        dp[index][target]=1;
        return true;
    }
    dp[index][target]=0;
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
        
        int[][] dp=new int[n][target+1];
        for(int[] arr:dp){
        Arrays.fill(arr,-1);
        }

        return f(n-1,target,nums,dp);
    }
}