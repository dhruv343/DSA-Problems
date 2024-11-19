class Solution {

    public int function(int index,int sum,int target,int[] nums){
    
    if(index<0){
    if(sum==target) return 1;
    else return 0;
    }

    //plus
    int plusTaken=function(index-1,sum+nums[index],target,nums);

    //minus
    int minusTaken=function(index-1,sum-nums[index],target,nums);

    return plusTaken+minusTaken;
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        int n=nums.length;
        return function(n-1,0,target,nums);
    }
}