class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int firstIndex=-1;
        int secondIndex=-1;
        int length=numbers.length;

        int i=0;
        int j=length-1;

        while(i<=j){
            int sum=numbers[i]+numbers[j];
            if(sum==target){
             return new int[]{i+1,j+1};
            }
            else if(sum<target){
                i++;
            }
            else{
                j--;
            }
        }
        return new int[]{-1,-1};

    }
}