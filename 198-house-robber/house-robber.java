class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int prev = nums[0];
        int prev2 = 0;
        int curri  = 0;

        for(int i=1 ; i<n ; i++){

            int pick = nums[i];
            if(i > 1){
                pick += prev2;
            }

            int notPick = prev;

            curri = Math.max(pick,notPick);
            prev2 = prev;
            prev = curri;
        }
        return curri;


    }
}