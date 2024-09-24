class Solution {
    public int maxArea(int[] height) {

      int n=height.length;
      int i=0;
      int j=n-1;
      int maxArea=0;

      while(i<j){
      int heightt=Integer.min(height[i],height[j]);
      maxArea=Integer.max(maxArea,heightt*(j-i));

      if(height[i]>height[j]){
        j--;
      }
      else{
        i++;
      }
  
      }  

      return maxArea;
    }
}