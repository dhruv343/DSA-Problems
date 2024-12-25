class Solution {
    void func(int[] arr,int ind,List<List<Integer>> answer,List<Integer> list)
    {  

      
            answer.add(new ArrayList<>(list));
       
        for(int i=ind;i<arr.length;i++){

            if(i>ind && arr[i]==arr[i-1]){
                continue;
            }
            
            list.add(arr[i]);
            func(arr,i+1,answer,list);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer=new ArrayList<>();
        Arrays.sort(nums);
        func(nums,0,answer,new ArrayList<>());
        
        return answer;
    }
}