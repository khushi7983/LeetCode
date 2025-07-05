class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            prevGreater[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nextGreater[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            long maxCount = (long)(i - prevGreater[i]) * (nextGreater[i] - i);
            long minCount = (long)(i - prevSmaller[i]) * (nextSmaller[i] - i);
            total += (maxCount - minCount) * nums[i];
        }

        return total;
    }
}
