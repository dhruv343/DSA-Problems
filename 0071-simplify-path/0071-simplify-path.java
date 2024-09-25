class Solution {
    public String simplifyPath(String path) {
        
     String[] words=path.split("/+");

     Stack<String> stack=new Stack<>();

     for(int i=0;i<words.length;i++){

        if(words[i].equals("..")){
            if(!stack.isEmpty()){
                stack.pop();
            }
        }
        else if(words[i].equals("") || words[i].equals(".")){
            continue;
        }
        else{
        stack.push(words[i]);
        }
     }

     StringBuilder sb=new StringBuilder();

     if(stack.isEmpty()){
        sb.append('/');
     }
     else{

     while(!stack.isEmpty()){
     sb.insert(0,'/'+stack.pop());
     }

     }
     
     return sb.toString();
    }
}