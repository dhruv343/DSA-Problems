class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];

            if(sum%k==0 && i+1>=2){
                return true;
            }
            
            int remSum=sum%k;

            if(map.containsKey(remSum)){
                int length=i-map.get(remSum);
                if(length>=2){
                    return true;
                }
            }
            if(nums[i]!=0){
            map.put(sum%k,i);
            }
        }
        return false;
    }
}