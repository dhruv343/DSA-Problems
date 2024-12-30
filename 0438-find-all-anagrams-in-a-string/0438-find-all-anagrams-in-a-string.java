class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int n=s.length();
        int m=p.length();
        
        ArrayList<Integer> answer=new ArrayList<>();

        if(m>n){
           return answer;
        }

        int[] p_freq=new int[26];
        int[] win_freq=new int[26];

        for(int i=0;i<m;i++){
            p_freq[p.charAt(i)-'a']++;
            win_freq[s.charAt(i)-'a']++;
        }

        if(Arrays.equals(p_freq,win_freq)){
            answer.add(0);
        }
        
        int st=1;
        int e=m;

        while(e<n){
            win_freq[s.charAt(e)-'a']++;
            win_freq[s.charAt(e-m)-'a']--;

            if(Arrays.equals(p_freq,win_freq)){
                answer.add(st);
            }

            st++;
            e++;
        }

        return answer;

        
    }
}