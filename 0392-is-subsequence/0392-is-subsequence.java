class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int p1=0;
        int p2=0;

        int n=s.length();
        int m=t.length();

        while(p1<n && p2<m){
            if(s.charAt(p1)==t.charAt(p2)){
                p1++;
            }
            p2++;
        }

        if(p1<n) return false;
        return true;
    }
}