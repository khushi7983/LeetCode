class Solution {
    public TreeNode balanceBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inorder(root,list);
       
        return buildBalancedBST(list,0,list.size()-1);

    }

    public void inorder(TreeNode root, List<Integer> list) {
    if (root == null) return;
    inorder(root.left, list);
    list.add(root.val);
    inorder(root.right, list);
    }

    public TreeNode buildBalancedBST(List<Integer> list, int start, int end) {
    if (start > end) return null;
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(list.get(mid));
    root.left = buildBalancedBST(list, start, mid - 1);
    root.right = buildBalancedBST(list, mid + 1, end);
    return root;
}
  

}