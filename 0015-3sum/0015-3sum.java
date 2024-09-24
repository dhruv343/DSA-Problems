class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int length=nums.length;
        List<List<Integer>> answer=new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<length-2;i++){
            int j=i+1;
            int k=length-1;

            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> ele=new ArrayList<>();
                    ele.add(nums[i]);
                    ele.add(nums[j]);
                    ele.add(nums[k]);
                    answer.add(ele);

                    while(j<k && nums[j]==nums[j+1])j++;
                    while(j<k && nums[j]==nums[j+1])k--;
                    j++;
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return answer;
        
    }
}