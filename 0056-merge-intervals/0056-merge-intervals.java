class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n=intervals.length;
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,Comparator.comparingInt(o -> o[0]));
        
        for(int i=0;i<n;i++){

            if(list.size()==0 || intervals[i][0] > list.get(list.size()-1)[1]){

                list.add(intervals[i]);
            }
            else{
                list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],intervals[i][1]);
            }
        }

        int[][] ans=new int[list.size()][2];

        for(int i=0;i<list.size();i++){
            for(int j=0;j<=1;j++){
                ans[i][j]=list.get(i)[j];
            }
        }

        return ans;
        
    }
}