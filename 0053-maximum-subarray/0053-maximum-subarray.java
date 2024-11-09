class Solution {
    public int maxSubArray(int[] nums) {

        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int start=-1;
        int end=-1;

        for(int i=0;i<nums.length;i++){

        sum+=nums[i];

        if(sum>maxSum){
            maxSum=sum;
        }
        
        if(sum<0){
            sum=0;
        }

        }

        return maxSum;
    }
}