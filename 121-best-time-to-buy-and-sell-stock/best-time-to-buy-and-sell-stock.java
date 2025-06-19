class Solution {
    public int maxProfit(int[] price) {
        
        int maxProfit = 0;
        int buyPrice = price[0];

        for(int i=1; i<price.length; i++){
            int currProfit = price[i] - buyPrice;
            maxProfit =  Math.max(currProfit, maxProfit);
            buyPrice =  Math.min(buyPrice,price[i]);
        }
           return maxProfit;
    }
}