class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int l=0;
        int r=0;
        int n=nums.length;
        int zeroes=0;
        int maxLen=0; 

        while(r<n){

            if(nums[r]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(nums[l]==0) zeroes--;
                l++;
            }

            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }

        return maxLen;
    }
}