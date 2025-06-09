class Solution {
    public int minPathSum(int[][] grid) {
       int m = grid.length;
       int n =  grid[0].length;
       int dp[][] =  new int[m][n];
      

       
       for(int i=0; i<m; i++){
         for(int j=0; j<n; j++){
          
           if( i==0 && j==0) dp[i][j] = grid[0][0];
           else{
             int up = (i>0)?   dp[i-1][j] : (int) Math.pow(10,9);
             int left = (j>0)?  dp[i][j-1] : (int) Math.pow(10,9);
            dp[i][j] = grid[i][j]+ Math.min(up,left);
           }

         }
       }
       return dp[m-1][n-1];
    }
}