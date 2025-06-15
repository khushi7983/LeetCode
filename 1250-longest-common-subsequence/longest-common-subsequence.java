class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        int dp[][] = new int[n1][n2];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }

        return f(n1-1,n2-1,text1,text2,dp);
    }
    public int f(int i, int j ,String s1, String s2 ,int[][] dp){
        if(i < 0 || j< 0){
            return 0;
        }
         
          if (dp[i][j] != -1) return dp[i][j];
          
        //match 
        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + f(i-1,j-1,s1,s2,dp);
        }

        // not match 
        return dp[i][j] = Math.max(f(i,j-1,s1,s2,dp),f(i-1,j,s1,s2,dp));
    }
}