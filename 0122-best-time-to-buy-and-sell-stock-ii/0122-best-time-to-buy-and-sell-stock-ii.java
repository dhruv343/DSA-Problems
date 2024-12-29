class Solution {
    public int maxProfit(int[] prices) {
        
        int shareBought=prices[0];
        int profit=0;

        for(int price:prices){
            int diff=price-shareBought;

            if(diff>0){
                profit+=diff;
                shareBought=price;
            }

            shareBought=Math.min(shareBought,price);
        }

        return profit;
    }
}