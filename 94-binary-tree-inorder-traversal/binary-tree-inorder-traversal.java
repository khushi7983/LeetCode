class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !st.isEmpty()) {
            // Go as left as possible
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            // Process node
            curr = st.pop();
            ans.add(curr.val);
            // Move to right child
            curr = curr.right;
        }
        return ans;
    }
}