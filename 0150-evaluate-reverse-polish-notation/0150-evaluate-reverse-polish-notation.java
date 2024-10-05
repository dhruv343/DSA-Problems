class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            
            if(tokens[i].equals("+") ||tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){

            if(tokens[i].equals("+")){
                int last1=stack.pop();
                int last2=stack.pop();
                int value=last2+last1;
                stack.push(value);
            }
            else if(tokens[i].equals("-")){
                int last1=stack.pop();
                int last2=stack.pop();
                int value=last2-last1;
                stack.push(value);
            }
            else if(tokens[i].equals("*")){
                int last1=stack.pop();
                int last2=stack.pop();
                int value=last2*last1;
                stack.push(value);
            }
            else if(tokens[i].equals("/")){
                int last1=stack.pop();
                int last2=stack.pop();
                int value=last2/last1;
                stack.push(value);
            }

            }

            else{
                int value=Integer.parseInt(tokens[i]);
                stack.push(value);
            }
        }
        return stack.pop();
    }
}