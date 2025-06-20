class Solution {
    public int maxProfit(int[] prices) {
        int n =  prices.length;
        int dp[][][] =  new int[n][2][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(0,1,2,prices,dp);
    }
    public int f(int i, int buy,int cap,int[] prices, int[][][] dp){

       
        if(i == prices.length) return 0;
        if(cap == 0) return 0;
         
        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

        int profit = 0;
        if(buy == 1){
            int buyStock = -prices[i] + f(i+1,0,cap,prices,dp);
            int notBuyStock = 0 + f(i+1,1,cap,prices,dp);

             profit  = Math.max(buyStock,notBuyStock);
        }
        else{
            int sell = prices[i] +f(i+1,1,cap-1,prices,dp);
            int notSell = 0 + f(i+1,0,cap,prices,dp);

             profit = Math.max(sell,notSell); 
        }
        return dp[i][buy][cap] = profit;
    }
}