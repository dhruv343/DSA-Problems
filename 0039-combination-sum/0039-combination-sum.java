class Solution {
    void func(int[] candidates, int target,int index,List<List<Integer>> answer,List<Integer> list)
    {  
        if(index==candidates.length){
            if(target==0){
                answer.add(new ArrayList<>(list));
            }
            return;
        }
       
       //notTake
       func(candidates,target,index+1,answer,list);

       //Take
       if(candidates[index]<=target){
             list.add(candidates[index]);
             func(candidates,target-candidates[index],index,answer,list);
             list.remove(list.size()-1);
       }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> answer=new ArrayList<>();
        func(candidates,target,0,answer,new ArrayList<>());
        
        return answer;
    }
}