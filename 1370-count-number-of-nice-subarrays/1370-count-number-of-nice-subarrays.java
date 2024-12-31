class Solution {

    private int func(int[] nums, int k){
        int l=0;
        int r=0;
        int n=nums.length;
        int count=0;
        int totalK=0;

        while(r<n){
            totalK+=(nums[r]%2);
            
            while(totalK>k){
                totalK-=(nums[l]%2);
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