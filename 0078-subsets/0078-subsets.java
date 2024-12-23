class Solution {

    public void func(int[] nums,int ind,List<List<Integer>> answer,List<Integer> element){

        if(ind==nums.length){
            answer.add(new ArrayList<>(element));
            return;
        }

        //exclude
        func(nums,ind+1,answer,element);

        //include
        element.add(nums[ind]);
        func(nums,ind+1,answer,element);
        element.remove(element.size()-1);

    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> answer=new ArrayList<>();
        List<Integer> element=new ArrayList<>();

        func(nums,0,answer,element);

        return answer;
    }
}