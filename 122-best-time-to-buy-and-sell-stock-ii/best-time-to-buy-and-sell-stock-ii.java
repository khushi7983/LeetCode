class Solution {
    public int maxProfit(int[] prices) {
        int n =  prices.length;
        if (n <= 1) return 0;
        int dp[][] =  new int[n+1][2];
        
        dp[n][0] = 0;
        dp[n][1] = 0;

        

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                if(j==1){
                int buyStock = -prices[i] + dp[i+1][0];
                int notBuyStock =  dp[i+1][1];

                dp[i][j] = Math.max(buyStock, notBuyStock); 
            }
            else{
                
                 int sellStock = prices[i] +dp[i+1][1];
                 int notSellStock =  dp[i+1][0];

                dp[i][j]  = Math.max(sellStock,notSellStock);
            }

            }
        }
        

        return dp[0][1];
    }
}

