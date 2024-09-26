class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        
        while(j<nums.length){
            if(nums[i]==nums[j]){ 
                j++;
            }
            else if(nums[i]!=nums[j]){
                i++;
                int swap=nums[j];
                nums[i]=nums[j];
                nums[j]=swap;
                j++;

            }
        }

        return i+1;

    }
}