class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int maxSum = Integer.MIN_VALUE;
        int i = 0;
            int sum  = 0;
            for(int j = 0; j<n; j++){
                if(sum < 0) sum = 0;
                sum += nums[j];
                maxSum = Math.max(sum,maxSum);
            }

        return maxSum;
        
    }
}