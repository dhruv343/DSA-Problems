class Solution {
    public int numberOfSubstrings(String s) {
        
        int st=0;
        int e=0;
        int n=s.length();
        int count=0;
        HashMap<Character,Integer> map=new HashMap<>();

        while(e<n){
            char ch=s.charAt(e);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.getOrDefault('a',0)>0 &&
            map.getOrDefault('b',0)>0 && map.getOrDefault('c',0)>0)
            {
               count+=(n-e);

               map.put(s.charAt(st),map.get(s.charAt(st))-1);

               st++;
            }
            e++;
        }

        return count;
    }
}