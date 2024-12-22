class Solution {
    public String largestOddNumber(String num) {
        
        int ind=-1;
        int n=num.length();

        for(int i=n-1;i>=0;i--){
            if((num.charAt(i)-'0')%2!=0){
                ind=i;
                break;
            }
        }

        if(ind==-1) return "";
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=ind;i++){
            sb.append(num.charAt(i));
        }

        return sb.toString();
    }
}