class Solution {

    private int noOf1s(int i){
     int count=0;
     while(i!=0){
        if((i & 1) == 1){
            count++;
        }
        i=i>>1;
     }

     return count;
    }
    public int[] countBits(int n) {
        int[] answer=new int[n+1];

        for(int i=0;i<=n;i++){
            answer[i]=noOf1s(i);
        }

        return answer;
    }
}