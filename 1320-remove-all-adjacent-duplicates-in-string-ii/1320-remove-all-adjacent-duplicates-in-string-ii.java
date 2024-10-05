class Solution {
    class Pair{
        char c;
        int count;

        Pair(char c,int count){
            this.c=c;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){

            int duplicates=0;
            if(!stack.isEmpty() && stack.peek().c==s.charAt(i)){
            duplicates=stack.peek().count;
            stack.pop();
            }

            if(duplicates+1<k){
            stack.push(new Pair(s.charAt(i),duplicates+1));
            }
            
        }

        while(!stack.isEmpty()){
            Pair p=stack.pop();
            char c=p.c;
            int count=p.count;

            while(count!=0){
                sb.append(c);
                count--;
            }
        }

        return sb.reverse().toString();
    }
}