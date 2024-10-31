class Solution {

    public int func(int[] nums, int k){

        int l=0;
        int r=0;
        int count=0;
        int sum=0;
        int n=nums.length;
        if(k<0) return 0;
        while(r<n){
            sum+=(nums[r]%2);
            while(sum>k){
                sum-=(nums[l]%2);
                l++;
            }

            count+=(r-l+1);
            r++;
        }

        return count;

    }
    public int numberOfSubarrays(int[] nums, int k) {
        return func(nums,k)-func(nums,k-1);
    }
}