class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }


        HashSet<Integer> set=new HashSet<>();
        
        for(int num:nums){
            set.add(num);
        }
        
        
        int maxLength=1;

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int element=nums[i];
                int length=1;

                while(set.contains(element+1)){
                    element+=1;
                    length++;
                }

                maxLength=Math.max(length,maxLength);
            }
        }

        return maxLength;
    }
}