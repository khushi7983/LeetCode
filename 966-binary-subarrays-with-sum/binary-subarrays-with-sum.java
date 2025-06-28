class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
       int ans  =  f(nums,goal) - f(nums,goal-1);
       return ans;

    }
    private int f(int nums[], int goal){
        int n = nums.length;
        int count = 0;
        int i = 0;
        int sum = 0;

        if (goal < 0) return 0;

        for(int j=0; j<n; j++){
            sum += nums[j];

            while( sum > goal){

                sum -= nums[i];
                i++;
            }
            count += j - i + 1;
        }
        return count;
    }
}