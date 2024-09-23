class Solution {

    public String shiftingLetters(String s, int[] shifts) {

        int n=shifts.length;
        
        for(int i=n-2;i>=0;i--){
            shifts[i]=(shifts[i]+shifts[i+1])%26;
        }
        
        StringBuilder str=new StringBuilder(s);

        for(int i=0;i<s.length();i++){
                char newChar=(char)((s.charAt(i)-'a'+shifts[i])%26+'a');
                str.setCharAt(i,newChar);
        }

        return str.toString();
    }
}
