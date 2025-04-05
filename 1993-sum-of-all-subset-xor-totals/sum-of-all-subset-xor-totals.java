class Solution {
    public int subsetXORSum(int[] nums) {
      return subsetXor(nums,0,0);
    }

    public int subsetXor(int[] nums , int index , int xor){
        // Base Case 
        if(index == nums.length){
            return xor;
        }
        int include = subsetXor(nums, index + 1, xor^nums[index]);
        int exclude = subsetXor(nums, index + 1, xor);
        
        return include + exclude;
    }
}