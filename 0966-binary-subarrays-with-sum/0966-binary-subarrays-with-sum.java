class Solution {

    public int func(int[] nums,int goal){

    int l=0;
    int r=0;
    int count=0;
    int sum=0;
    if(goal<0){
        return 0;
    }

    while(r<nums.length){
       sum+=nums[r];

       //sum > goal
       while(sum>goal){
        sum-=nums[l];
        l++;
       }

       //sum is less than and equal to goal
       count+=(r-l+1);
       r+=1;
    }

    return count;

    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums,goal)-func(nums,goal-1);
    }
}