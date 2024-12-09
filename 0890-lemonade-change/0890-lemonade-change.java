class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int n5d=0;
        int n10d=0;

        for(int i:bills){
            if(i==5){
                n5d++;
            }
            else if(i==10){
                if(n5d>0){
                    n10d++;
                    n5d--;
                }
                else return false;
            }
            else{
                if(n5d>0 && n10d>0){
                    n5d--;
                    n10d--;
                }
                else if(n5d>=3){
                    n5d-=3;
                }
                else return false;
            }
        }

        return true;
    }
}