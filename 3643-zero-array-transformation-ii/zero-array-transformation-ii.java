class Solution {
    private int n, Q;

    private boolean isValid(int[] nums, int[][] queries, int k) {
        int[] diff = new int[n]; // Difference array

        // Apply the first 'k' queries
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];

            diff[l] -= x;
            if (r + 1 < n) diff[r + 1] += x;
        }

        // Apply the difference array to reconstruct modified nums
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += diff[i];
            if (nums[i] + cumSum > 0) return false; // Not all zeros
        }

        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        n = nums.length;
        Q = queries.length;

        if (Arrays.stream(nums).allMatch(x -> x == 0)) {
            return 0; // Already a Zero Array
        }

        int left = 0, right = Q, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(Arrays.copyOf(nums, n), queries, mid)) {
                 // Use a copy to avoid      modifying the original array
                ans = mid;       // Found a possible answer
                right = mid - 1; // Try a smaller k
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}