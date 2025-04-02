class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTriplet = 0;
        for(int i=0; i<n; i++){
            for( int j = i+1; j<n; j++){
                for(int k= j+1;k<n; k++){
                    long triplet = (long) (nums[i] - nums[j]) * nums[k];
                    if(triplet >= maxTriplet){
                        maxTriplet = triplet;
                    }
                }
            }  
        }
        return maxTriplet;
    }
}