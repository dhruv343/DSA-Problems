class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int maxLength=0;
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=nums[i]==0?-1:1;
            if(sum==0){
                maxLength=i+1;
            }
            else if(map.containsKey(sum)){
                maxLength=Integer.max(maxLength,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }

        return maxLength;

    }
}