class Solution {
    public int maximumCount(int[] nums) {
         int n = nums.length;
         int odd = 0;
         int even = 0;
         for(int i = 0; i<n ; i++){
            //   if(nums[i] )
              if(nums[i] > 0){
                 even ++;
              }
              if(nums[i] < 0){
                odd++;
              }
         }
         return Math.max(odd,even);
    }
}