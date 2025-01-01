class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] answer=new int[n];
        Arrays.fill(answer,-1);
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<2*n;i++){

            while(!stack.isEmpty() && nums[i%n]>nums[stack.peek()]){
               answer[stack.pop()]=nums[i%n];
            }
            if(i<n){
                stack.push(i);
            }
        }

        return answer;

    }
}