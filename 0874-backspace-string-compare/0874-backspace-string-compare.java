class Solution {

    public static String backrem(String str){
        StringBuilder sb=new StringBuilder();
        for(char i:str.toCharArray()){
            if(i!='#'){
                sb.append(i);
            }
            else{
            if(sb.length()!=0){
                sb.delete(sb.length()-1,sb.length());
            }
            }
            
        }
        return sb.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        return backrem(s).equals(backrem(t));
    }
}