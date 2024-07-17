class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0 ;
        int i = 0 ;
        for(i = 0 ; i < nums.length ; i ++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1 ;
    }
}