class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count  = 0;
        int maxCount = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) count = 0;
            if(nums[i] == 1){
                 count++;
                maxCount = Math.max(count,maxCount); 
            }     
        }
        return maxCount;
        
    }
}