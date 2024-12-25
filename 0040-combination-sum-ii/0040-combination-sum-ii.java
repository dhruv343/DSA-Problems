class Solution {

    void func(int[] arr, int target,int ind,List<List<Integer>> answer,List<Integer> list)
    {  

        if(target==0){
            answer.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<arr.length;i++){

            if(i>ind && arr[i]==arr[i-1]){
                continue;
            }
            if(target<arr[i]){
             break;
            }
            list.add(arr[i]);
            func(arr,target-arr[i],i+1,answer,list);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer=new ArrayList<>();
        Arrays.sort(candidates);
        func(candidates,target,0,answer,new ArrayList<>());
        
        return answer;
    }
}