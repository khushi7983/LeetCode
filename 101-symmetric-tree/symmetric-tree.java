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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
       
    
       if( isSameTree(root.left , invertTree(root.right)) == true){
           return true;
       }
       return false; 
    }
    public TreeNode invertTree(TreeNode root) {
         if( root == null) return null;
          
         TreeNode temp = root.left;
          root.left = root.right ; 
          root.right = temp;

         invertTree(root.left);
         invertTree(root.right);
         
        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case 
        if( p== null && q== null) return true;
        if( p==null && q!= null) return false;
        if( p!=null && q==null) return false;     

        // main logic
       if(p.val != q.val) return false;
       if( isSameTree(p.left , q.left) == false) return false;
       if( isSameTree(p.right , q.right) == false) return false;


       return true;

    }

}