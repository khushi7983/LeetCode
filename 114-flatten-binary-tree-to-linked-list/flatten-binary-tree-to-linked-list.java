class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        preorder(root,ans);
        int n = ans.size();
        for(int i = 0; i < n; i++){

            ans.get(i).left = null;
            if(i<n-1) ans.get(i).right = ans.get(i+1);
        }
    }
    public void preorder(TreeNode root , List<TreeNode> ans){
        if(root == null) return;
        ans.add(root);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }
}