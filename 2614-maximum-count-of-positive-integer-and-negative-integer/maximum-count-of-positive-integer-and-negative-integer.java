class Solution {
    public int maximumCount(int[] nums) {
         int n = nums.length; 
         int low = 0;
         int high = n -1;
        
         int pos = 0;
         int neg = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < 0) {
                neg = mid + 1; // Count of negative numbers
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Finding the count of positive numbers
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > 0) {
                pos = n - mid; // Count of positive numbers
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

         return Math.max(neg,pos);
    }
}