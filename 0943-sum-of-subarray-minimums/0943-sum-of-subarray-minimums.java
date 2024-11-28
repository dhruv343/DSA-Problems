class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] psl=new int[n];
        int[] nsl=new int[n];
        Stack<Integer> stack=new Stack<>();

        Arrays.fill(psl,-1);
        Arrays.fill(nsl,n);

        for(int i=0;i<n;i++){

            while(!stack.isEmpty() && arr[i]<arr[stack.peek()]){
               stack.pop();
            }
            psl[i]=stack.isEmpty()?-1:stack.peek();

            stack.push(i);
        }

        stack.clear();
        
        for(int i=0;i<n;i++){

            while(!stack.isEmpty() && arr[i]<arr[stack.peek()]){
               nsl[stack.pop()]=i;
            }
            stack.push(i);
        }

        int mod=(int)1e9+7;
        long answer=0;

        for(int i=0;i<n;i++){
            long l=i-psl[i];
            long r=nsl[i]-i;

            long contribution=((l*r)*arr[i]);

            answer=(answer+contribution)%mod;
        }

        return (int)answer;

    }
}