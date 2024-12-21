class Solution {
    public String removeOuterParentheses(String s) {
        
        int flag=0;
        int count=0;
        StringBuilder str=new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' && flag==0){
                flag=1;
            }
            else if(s.charAt(i)=='(' && flag==1){
                str.append(s.charAt(i));
                count++;
            }
            else if(s.charAt(i)==')' && count>0){
                count--;
                str.append(s.charAt(i));
            }
            else if(s.charAt(i)==')' && count<=0){
                flag=0;
            }
        }

        return str.toString();
    }
}