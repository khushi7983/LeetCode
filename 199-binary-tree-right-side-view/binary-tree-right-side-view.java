/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



// class Solution {
//     public int levels(TreeNode root){
//         if(root==null) return 0;
//         return 1 + Math.max(levels(root.left), levels(root.right));
//     }
//     public void preorder(TreeNode root , int level , List<Integer> ans ){
//         if(root == null) return;
//         // ans.set(level,root.val);
//         preorder(root.right,level+1,ans);
//         preorder(root.left,level+1,ans);

//     }
//     public List<Integer> rightSideView(TreeNode root) {
//         int n = levels(root);
//         List<Integer> ans  = new ArrayList<>();
//         for( int i=0; i<n ; i++){
//             ans.add(0);
//         }
//         preorder( root,0,ans);
//         return ans;
//     }
// }



class Solution {
    public int levels(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public void preorder(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;
        
        // Ensure the first node at each level is added
        if (level == ans.size()) {
            ans.add(root.val);
        }
        
        // Prioritize right subtree first to get the rightmost nodes
        preorder(root.right, level + 1, ans);
        preorder(root.left, level + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, 0, ans);
        return ans;
    }
}