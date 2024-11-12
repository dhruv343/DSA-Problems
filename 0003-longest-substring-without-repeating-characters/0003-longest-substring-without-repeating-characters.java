class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int l=0;
        int r=0;
        int n=s.length();
        int maxLength=0;
        HashMap<Character,Integer> map=new HashMap<>();

        while(r<n){
            if(map.containsKey(s.charAt(r))){
               map.remove(s.charAt(l));
               l+=1;
            }
            else{
                map.put(s.charAt(r),1);
                maxLength=Math.max(maxLength,r-l+1);
                r+=1;
            }
        }

        return maxLength;

    }
}