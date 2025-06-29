class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = f(nums,k) - f(nums,k-1);
        return ans;
    }
    public int f(int[] nums, int k){
         int n = nums.length;
         int count  = 0;
         int i = 0;
         
         int oddCount = 0;
         for(int j=0; j<n; j++){
            if(nums[j] % 2 != 0){
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[i] % 2 != 0) {
                    oddCount--;
                }
                i++;
            }

            count += j - i + 1;



         }
         
         return count;
    }
}