class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] =  new int[n][n+1];
        for (int[] row : dp){
          Arrays.fill(row, -1);
        }
        return f(0,-1,nums,dp);

    }
    public int f(int i, int prev, int[] nums, int[][] dp){
        int n = nums.length;
       
       if(i == n) return 0;
       
       if(dp[i][prev + 1] != -1) return dp[i][prev + 1];
       
       int notTake =  f(i+1,prev,nums,dp);
       int take = 0;
       if(prev == -1 || nums[i] > nums[prev]){
           take = 1 + f(i+1,i,nums,dp);
       }

       return dp[i][prev + 1] = Math.max(take,notTake);

    }
}