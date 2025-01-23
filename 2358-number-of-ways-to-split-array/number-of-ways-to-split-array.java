class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long l =0;
        long r =0;
        int count = 0 ;
        for( int x : nums){
            r = r + x ;
        }
        for(int i = 0 ; i<n-1 ; i++){
            l = l + nums[i];
            r = r - nums[i];
            if(l >= r ){
                count++;
            }
        }
        return count;
    }
}