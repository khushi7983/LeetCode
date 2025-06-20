class Solution {
    public int maxProfit(int[] prices) {
        int n =  prices.length;
         if (n <= 1) return 0;
        int dp[][][] =  new int[n+1][2][3];
        
        for(int i = 0; i<n; i++){
            for(int j=0; j<=1; j++){
                dp[i][j][0] = 0;
            }
        }
        for(int j = 0; j<=1; j++){
            for(int k=0; k<=2; k++){
                dp[n][j][k] = 0;
            }
        }
        

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                for(int k=1; k<=2; k++){
                if(j==1){
                int buyStock = -prices[i] + dp[i+1][0][k];
                int notBuyStock =  dp[i+1][1][k];

                dp[i][j][k] = Math.max(buyStock, notBuyStock); 
                }
                else{
                  int sellStock = 0;
                    if (k > 0)   
                
                     sellStock = prices[i] +dp[i+1][1][k-1];
                 int notSellStock =  dp[i+1][0][k];

                  dp[i][j][k]  = Math.max(sellStock,notSellStock);
                }
              }

            }
        }
        

        return dp[0][1][2];
    }
}

