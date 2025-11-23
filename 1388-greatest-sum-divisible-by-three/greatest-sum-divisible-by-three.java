class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int r1_a = Integer.MAX_VALUE, r1_b = Integer.MAX_VALUE;
        int r2_a = Integer.MAX_VALUE, r2_b = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            int r = num % 3;
            if (r == 1) {
                if (num < r1_a) {
                    r1_b = r1_a;
                    r1_a = num;
                } else if (num < r1_b) {
                    r1_b = num;
                }
            }
            if (r == 2) {
                if (num < r2_a) {
                    r2_b = r2_a;
                    r2_a = num;
                } else if (num < r2_b) {
                    r2_b = num;
                }
            }
        }
        if (sum % 3 == 0) return sum;
        int ans = -1;
        if (sum % 3 == 1) {
            if (r1_a != Integer.MAX_VALUE)
                ans = Math.max(ans, sum - r1_a);
            if (r2_a != Integer.MAX_VALUE && r2_b != Integer.MAX_VALUE)
                ans = Math.max(ans, sum - (r2_a + r2_b));
        } 
        else { 
            if (r2_a != Integer.MAX_VALUE)
                ans = Math.max(ans, sum - r2_a);
            if (r1_a != Integer.MAX_VALUE && r1_b != Integer.MAX_VALUE)
                ans = Math.max(ans, sum - (r1_a + r1_b));
        }
        return ans < 0 ? 0 : ans;
    }
}
