class Solution {
    public int maxProduct(int[] nums) {
        int prefixSum=1;
        int suffixSum=1;
        int ans=Integer.MIN_VALUE;
        int n=nums.length;

        for(int i=0;i<n;i++){
           
           if(prefixSum==0) prefixSum=1;
           if(suffixSum==0) suffixSum=1;
            prefixSum*=nums[i];
            suffixSum*=nums[n-1-i];
            ans=Math.max(ans,Math.max(prefixSum,suffixSum));
        }

        return ans;
    }
}