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

    int maxResult = Integer.MIN_VALUE; 

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxResult;
    }

    public int maxSum(TreeNode root){

        if(root == null) return 0;

        // this will handle the neg as well
        int leftmax = Math.max(0,maxSum(root.left));
        int rightmax = Math.max(0,maxSum(root.right));

        maxResult = Math.max(maxResult, root.val + leftmax + rightmax);

        return root.val + Math.max(leftmax, rightmax);
    }
}