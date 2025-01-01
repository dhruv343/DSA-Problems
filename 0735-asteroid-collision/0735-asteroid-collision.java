class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        
        Stack<Integer> stack=new Stack<>();
        int n=asteroids.length;


        for(int num:asteroids){
            if(num>=0) stack.push(num);
            else{
                while(!stack.isEmpty() && stack.peek()>0 && Math.abs(num)>stack.peek()){
                    stack.pop();
                }


                if(stack.isEmpty() || stack.peek()<0){
                      stack.push(num);
                }

                if(stack.peek()==-num){
                    stack.pop();
                }
            }
        }

        int[] ans=new int[stack.size()];

        int i=stack.size()-1;

        while(!stack.isEmpty()){
            ans[i]=stack.pop();
            i--;
        }

        return ans;

    }
}