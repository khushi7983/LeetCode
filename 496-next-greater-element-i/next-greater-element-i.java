class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         int n1 = nums1.length;
        int[] ans = new int[n1];

        int[] nextRightArr = nextRight(nums2);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nextRightArr[i]);
        }

        for (int i = 0; i < n1; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;

    }
    public int[] nextRight(int[] nums2){
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        res[n-1] = -1;
        for(int i= n-1; i>=0; i--){
            
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();

            st.push(nums2[i]);
            
        }
        return res;
    }
}