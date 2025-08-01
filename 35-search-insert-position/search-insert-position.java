class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int ans = n;  // Default insert position at the end

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                r = mid - 1;  
            } else {
                l = mid + 1;  
            }
        }

        return ans;
    }
}
