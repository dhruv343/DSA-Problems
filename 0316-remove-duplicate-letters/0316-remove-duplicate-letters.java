class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] freq=new int[26];
        boolean[] visited=new boolean[26];

        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        Stack<Character> stack=new Stack<>();

        for(char ch:s.toCharArray()){
          
          freq[ch-'a']--;

          if(visited[ch-'a']){
            continue;
          }

          while(!stack.isEmpty() && stack.peek()>ch && freq[stack.peek()-'a']>0){
              visited[stack.pop()-'a']=false;
          }

          stack.push(ch);
          visited[ch-'a']=true;
          
        }


        StringBuilder sb=new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}