class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] =  new int[m][n];

       
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if( i == 0 && j==0)  dp[0][0] = 1;  
                else{ 
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = left+up;
                }
            
            }
        }
        return dp[m-1][n-1];

    }
    
}