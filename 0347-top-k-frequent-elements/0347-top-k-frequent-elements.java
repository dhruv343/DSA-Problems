class Solution {
    class Pair{
        int ele;
        int count;

        Pair(int e,int c){
            this.ele=e;
            this.count=c;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[k];

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> b.count-a.count);

        for(int i:map.keySet()){
            pq.add(new Pair(i,map.get(i)));
        }

        for(int i=0;i<k;i++){
            ans[i]=pq.remove().ele;
        }
        return ans;
        

    }
}