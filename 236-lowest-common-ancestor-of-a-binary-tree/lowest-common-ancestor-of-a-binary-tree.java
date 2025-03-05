/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean exists(TreeNode root , TreeNode node){
            if(node == root) return true;
            if(root == null) return false;
            return exists(root.left , node) || exists(root.right , node);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
         if(p==root || q==root) return root;
         boolean PInLST = exists(root.left , p);
         boolean QInLST = exists(root.left , q);
         if(PInLST==true &&  QInLST == true) return  lowestCommonAncestor(root.left ,p,q);
         if(PInLST==false &&  QInLST == false) return  lowestCommonAncestor(root.right ,p,q);
         else return root;
    }
}