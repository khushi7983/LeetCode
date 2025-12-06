class Solution {

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 2];

        dp[0] = 1;
        prefix[1] = 1;

        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; right++) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[right])
                maxQ.pollLast();
            maxQ.addLast(right);
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[right])
                minQ.pollLast();
            minQ.addLast(right);
            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if (maxQ.peekFirst() == left) maxQ.pollFirst();
                if (minQ.peekFirst() == left) minQ.pollFirst();
                left++;
            }
            int i = right + 1;
            dp[i] = (prefix[i] - prefix[left] + MOD) % MOD;
            prefix[i + 1] = (prefix[i] + dp[i]) % MOD;
        }
        return (int) dp[n];
    }
}
