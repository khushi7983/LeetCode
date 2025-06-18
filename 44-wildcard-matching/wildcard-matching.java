class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,m-1,s,p,dp) == 1;
    }
    static boolean isAllStars(String p, int j) {
    for (int i = 0; i <= j; i++) {
      if (p.charAt(i) != '*')
        return false;
    }
    return true;
   }
    public int f(int i, int j, String s, String p, int dp[][]){
        if(i<0 && j<0) return 1;
        if(j<0) return 0;
        if(i<0) return isAllStars(p, j) ? 1 : 0; 
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            dp[i][j] = f(i-1,j-1,s,p,dp);
        }
        else if (p.charAt(j) == '*') {
            dp[i][j] = (f(i - 1, j, s, p, dp) == 1 || f(i, j - 1, s, p, dp) == 1) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j];
    }
}