class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
      int n = nums.length;
      int l = 1;
      int r = getMax(nums);
      int ans = -1;

      while( l <= r){
        int mid = l + (r - l)/2;
        if(f(nums,mid) <= threshold){
            ans = mid;
            r = mid - 1;
        }
        else{
            l = mid + 1;
        }
      }
      return ans;        
    }
    public int f(int[] nums, int div){
        int n = nums.length; 
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)(nums[i]) / (double)(div));
        }
        return sum;
    }
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}