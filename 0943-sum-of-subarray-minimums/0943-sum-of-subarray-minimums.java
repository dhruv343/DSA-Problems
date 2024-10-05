class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> s=new Stack<>();
        int[] psl=new int[arr.length];
        int[] nsl=new int[arr.length];

        Arrays.fill(psl,-1);
        Arrays.fill(nsl,arr.length);
        
        //finding psl for every element
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[i]<arr[s.peek()]){
            s.pop();
            }
            psl[i]=s.isEmpty()?-1:s.peek();
            s.push(i);
        }
        s.clear();
        //finding nsl for every element 
        for(int i=0;i<arr.length;i++){
            while(!s.empty() && arr[i]<arr[s.peek()]){
            int ele=s.pop();
            nsl[ele]=i;
            }
            s.push(i);
        }


        long answer=0;
        int mod=(int)1e9+7;

        for(int i=0;i<arr.length;i++){
            
            long left=i-psl[i];
            long right=nsl[i]-i;
            
            long contribution=(left*right)*arr[i];
            
            answer = (answer + contribution) % mod;

        }

        return (int)answer;
    }
}