class Solution {
    public int trap(int[] height) {

        int n=height.length;
        int[] suffix=new int[n];

        suffix[n-1]=height[n-1];

        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(height[i],suffix[i+1]);
        }

        int leftMax=-1;
        int result=0;

        for(int i=0;i<n;i++){

            leftMax=Math.max(height[i],leftMax);

            int qwe=Math.min(leftMax,suffix[i]);

            if(height[i]<qwe){
               result+=(qwe-height[i]);
            }
            
        }

        return result;
    }
}