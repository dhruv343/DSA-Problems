class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n=cardPoints.length;
        int totalSum=0;
        int windowSum=0;
        int minWindowSum=0;
        int z=n-k;
        int l=0;
        int r=z-1;

        for(int i:cardPoints){
            totalSum+=i;
        }

        for(int i=0;i<=r;i++){
            windowSum+=cardPoints[i];
        }

        minWindowSum=windowSum;

        while(r<n-1){
            windowSum+=cardPoints[r+1];
            windowSum-=cardPoints[l];
            minWindowSum=Math.min(windowSum,minWindowSum);
            l++;
            r++;
        }

        return totalSum-minWindowSum;
    }
}