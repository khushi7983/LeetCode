class Solution {
    private int sum;
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.right);
        root.val += sum;
        sum = root.val;
        inorder(root.left);
        
    }
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        inorder(root);
        return root;
        
    }
}