class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        // int[] numsDouble=new int[2*nums.length];
        int n=nums.length;
        Stack<Integer> s=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        
        // for(int i=0;i<2*n;i++){
        //     numsDouble[i]=nums[i%n];
        // }

        for(int i=0;i<2*n;i++){
        while(!s.isEmpty() && nums[i%n]>nums[s.peek()]){
        map.put(s.pop(),nums[i%n]);
        }
        if((i%n)<n){
            s.push(i%n);
        }
        }

        for(int i=0;i<n;i++){
            nums[i]=map.getOrDefault(i,-1);
        }
        
        return nums;
    }
}