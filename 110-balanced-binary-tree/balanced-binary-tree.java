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
//     public int levels( TreeNode root ){
//         if(root == null) return 0;
//         return 1+ Math.max(levels(root.left) , levels(root.right));
      
//     }
//     public boolean isBalanced(TreeNode root) {
       
//        if(root == null) return true;

//        int diff = Math.abs(levels(root.left) - levels(root.right));
//        if(diff > 1){
//         return false;
//        }
//        boolean lst = isBalanced(root.left);
//        if(lst == false) return false;
//        boolean rst = isBalanced(root.right);
//        if(rst == false) return false;
       
//        return true;
//     }
// }


class Solution {
    public int levels( TreeNode root , boolean[] ans ){
        if(root == null) return 0;

            int lst = levels(root.left , ans);
            int rst =  levels(root.right , ans);

            int diff  = Math.abs(lst - rst);
            if(diff > 1){
                ans[0] = false;
            }

        return 1+ Math.max(lst, rst);
      
    }
    public boolean isBalanced(TreeNode root ) {

       boolean[] ans = {true};
       levels(root , ans);
       return ans[0];
      
    }
}













