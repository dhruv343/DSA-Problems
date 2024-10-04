class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> s=new Stack<>();
        // HashMap<Integer,Integer> map=new HashMap<>();
        int[] arr=new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            while(!s.isEmpty() && temperatures[i]>temperatures[s.peek()]){
            int q=s.pop();
            arr[q]=i-q;
            }


            s.push(i);
        }
        
        return arr;

        // for(int i=0;i<temperatures.length;i++){
        //     int q=map.getOrDefault(i,0);
        //     if(q!=0){
        //         temperatures[i]=q-i;
        //     }
        //     else{
        //         temperatures[i]=0;
        //     }
        // }

        // return temperatures;
    }
}