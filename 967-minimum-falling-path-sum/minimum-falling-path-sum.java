class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int dp[][] = new int[m][n];
        
        for(int j=0; j<n; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){

                int up = dp[i-1][j];
                int rd = j < n - 1 ? dp[i - 1][j + 1] : (int) 1e9;
                int ld = j > 0 ? dp[i - 1][j - 1] : (int) 1e9;

                dp[i][j] = matrix[i][j] + Math.min(up,Math.min(rd,ld));
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
           min = Math.min(min,dp[n-1][j]);
        }
        return min;
    }    
}