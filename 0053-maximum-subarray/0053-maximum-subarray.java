class Solution {
    public int maxSubArray(int[] nums) {

        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int start=-1;
        int ansStart=-1;
        int ansEnd=-1;

        for(int i=0;i<nums.length;i++){
        if(sum==0){
            start=i;
        }
        sum+=nums[i];

        if(sum>maxSum){
            maxSum=sum;
            ansStart=start;
            ansEnd=i;
        }
        
        if(sum<0){
            sum=0;
        }

        }

        for(int i=ansStart;i<=ansEnd;i++){
            System.out.print(nums[i]+" ");
        }

        return maxSum;
    }
}