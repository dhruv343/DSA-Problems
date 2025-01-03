class Solution {

    public int func(int ind,int[] nums,int[] dp){

       
      
      int n=nums.length;

      if(ind>=n-1) return 0;

      if(dp[ind]!=-1) return dp[ind];

      int mini=Integer.MAX_VALUE;

      for(int i=1;i<=nums[ind];i++){
           int jumps=func(ind+i,nums,dp);
           if(jumps!=Integer.MAX_VALUE){
           mini=Math.min(mini,jumps+1);
           }
      }

      return dp[ind]=mini;
    }
    public int jump(int[] nums) {
        
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return func(0,nums,dp);
    }
}