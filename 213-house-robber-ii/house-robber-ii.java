class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int case1 = linearRob(nums,0,n-2);
        int case2 = linearRob(nums,1,n-1);

        int ans = Math.max(case1,case2);   
        return ans; 
    }
    public int linearRob(int[] nums , int start , int end){
        int prev = nums[start];
        int prev2 = 0;

        for(int i=start+1 ; i<=end ; i++){

            int pick = nums[i];
            if(i > start+1){
                pick += prev2;
            }

            int notPick = prev;

            int curri = Math.max(pick,notPick);
            prev2 = prev;
            prev = curri;
        }
        return prev; 
    }

}