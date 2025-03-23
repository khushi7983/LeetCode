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

    public List<Integer> copy(  List<Integer> arr){
        List<Integer> list = new ArrayList<>();
        for( int ele : arr){
           list.add(ele);
        }
        return list;
    }
    
    public void helper(TreeNode root, int target, List<Integer> arr ,List<List<Integer>> ans){
         if(root == null) return;
         if(root.left == null && root.right == null) {
            if(root.val == target){
                arr.add(root.val);
                ans.add(arr);
            }
            return;
         }
         
         arr.add(root.val);
         List<Integer> arr1 =copy(arr);
         List<Integer> arr2 =copy(arr);
         helper(root.left,target-root.val,arr1,ans);
         helper(root.right,target-root.val,arr2,ans);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> arr = new ArrayList<>();
         helper(root,targetSum,arr,ans);
         return ans;
    }
}