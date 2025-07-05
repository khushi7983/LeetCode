class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        // find Previous Less Element (PLE)
        Stack<Integer> stack = new Stack<>();
        int[] ple = new int[n]; 
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        //  Next Less Element (NLE)
        stack.clear();
        int[] nle = new int[n]; // stores index of next less element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate result using contribution of each element
        long result = 0;
        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            long contribution = (arr[i] * left % MOD) * right % MOD;
            result = (result + contribution) % MOD;
        }

        return (int) result;
    }
}
