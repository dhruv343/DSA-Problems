class Solution {
    public int reverse(int x) {
        int y = x;
        if (x < 0) {
         x=Math.abs(x);
        }

        long reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }

     
        if(reversed<(-Math.pow(2,31)) || reversed>Math.pow(2,31) ){
        return 0;
        }

        else if(y<0){
            return (int)-reversed;
        }
        return (int)reversed;
    }
}