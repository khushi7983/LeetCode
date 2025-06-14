class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
         for(int rows[] : dp){
            Arrays.fill(rows,-1);
         }
         return f(n-1,amount,coins,dp);
    }
    public int f(int i,int amount, int[] coins , int[][] dp ){
        // Base Case
        if(i == 0){
            return (amount % coins[0] == 0) ? 1 : 0;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        int notTake = f(i-1,amount,coins,dp);
        int take = 0;
        if(amount >= coins[i]){
            take = f(i,amount-coins[i],coins,dp);
        }
        return dp[i][amount] = take + notTake;
    }
}