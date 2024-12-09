class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int nCookies=s.length;
        int nChildren=g.length;

        int l=0;
        int r=0;


        while(r<nCookies && l<nChildren){
            if(g[l]<=s[r]){
                l=l+1;
            }
            r=r+1;
        }

        return l;
    }
}