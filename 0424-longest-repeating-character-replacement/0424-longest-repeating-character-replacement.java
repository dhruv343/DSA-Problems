class Solution {
    public int characterReplacement(String s, int k) {
        
        int len=0;
        int n=s.length();
        int l=0;
        int r=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int maxFreq=0;

        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            maxFreq=Math.max(maxFreq,map.get(s.charAt(r)));
            
            int total=r-l+1;
            int noOfConversions=total-maxFreq;

            if(noOfConversions<=k){
                len=Math.max(len,total);
            }
            else{

            // if(maxFreq==map.get(s.charAt(l))){
            //     map.put(s.charAt(l),map.get(s.charAt(l))-1);
            //     if(map.get(s.charAt(l))==0){
            //         map.remove(s.charAt(l));
            //     }
            //     maxFreq--;
            // }

            if(maxFreq==map.get(s.charAt(l))){
                maxFreq--;
            }

            map.put(s.charAt(l),map.get(s.charAt(l))-1);
            if(map.get(s.charAt(l))==0){
                 map.remove(s.charAt(l));
            }
            l++;

            }

            r++;

        }
        

        return len;
    }
}