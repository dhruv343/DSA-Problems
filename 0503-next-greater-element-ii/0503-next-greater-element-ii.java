class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<2*n;i++){

            while(!stack.isEmpty() && nums[i%n]>nums[stack.peek()]){
                map.put(stack.pop(),nums[i%n]);
            }
            if(i<n){
                stack.push(i);
            }
        }

        for(int i=0;i<nums.length;i++){
            nums[i]=map.getOrDefault(i,-1);
        }

        return nums;

    }
}