class Solution {
    public void func(List<String> answer,int left,int right,String s,int n){

        if(s.length()==n*2){
            answer.add(s);
            return;
        }
        
        if(left<n){
            func(answer,left+1,right,s+'(',n);
        }
        if(right<left){
            func(answer,left,right+1,s+')',n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> answer=new ArrayList<>();
        
        func(answer,0,0,"",n);

        return answer;
    }
}