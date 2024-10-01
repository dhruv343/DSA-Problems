class Solution {

    class Pair{
        Boolean takesAtLast;
        int minJumps;

        Pair(Boolean bool,int minJ){
            this.takesAtLast=bool;
            this.minJumps=minJ;
        }
    }

    public Pair f(int[] nums,int ind,Pair[] dp){
    
    if(ind==nums.length-1){
        return new Pair(true,0);
    }
    if(ind>nums.length-1 || nums[ind]==0){
        return new Pair(false,-1);
    }
    
    if(dp[ind].takesAtLast!=null && dp[ind].minJumps!=-1){
        return dp[ind];
    }

    int min=Integer.MAX_VALUE;
    Boolean takesAtLast=false;

    for(int i=1;i<=nums[ind];i++){
        Pair ele=f(nums,ind+i,dp);
        if(ele.takesAtLast){
            min=Integer.min(min,ele.minJumps);
            takesAtLast=true;
        }
    }
    
    return dp[ind]= new Pair(takesAtLast,min+1);

    }

    public int jump(int[] nums) {
        
        Pair[] dp=new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=new Pair(null,-1);
        }
        return f(nums,0,dp).minJumps;
    }
}