class Solution {
    public int[] countBits(int n) {
        int result[] = new int[n + 1];
        if (n == 0)
            return result;

        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[i / 2] + 1;
            }
        }

        return result;
    }
}
