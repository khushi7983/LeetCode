import java.util.Arrays;

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int i = 0;
        int j = 1;
        
        while (j < n) {
            if (nums[i] == nums[j]) {
                return nums[i];
            }
            i++;
            j++;
        }
        
        return -1; 
    }
}
