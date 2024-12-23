class Solution {

    int func(HashMap<Character,Integer> map){
        int minFreq=Integer.MAX_VALUE;
        int maxFreq=Integer.MIN_VALUE;

        for(int freq:map.values()){
            maxFreq=Math.max(maxFreq,freq);
            minFreq=Math.min(minFreq,freq);
        }

        return maxFreq-minFreq;

    }
    public int beautySum(String s) {

       int n=s.length();
       int beauty=0;
       

       for(int i=0;i<n;i++){
        HashMap<Character,Integer> map=new HashMap<>();
        

        for(int j=i;j<n;j++){
          char ch=s.charAt(j);
          map.put(ch,map.getOrDefault(ch,0)+1);

          beauty+=func(map);
        }
       }

       return beauty;
    }
}