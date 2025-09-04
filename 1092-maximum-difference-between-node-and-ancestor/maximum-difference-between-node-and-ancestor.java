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
    int result = 0;

    //  Pair class to hold min and max
    class Pair {
        int min, max;
        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return result;
    }

    private Pair dfs(TreeNode node) {
        if (node == null) return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);

        if (node.left == null && node.right == null) {
            return new Pair(node.val, node.val);
        }

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        

        int minVal = Math.min(node.val, Math.min(left.min, right.min));
        int maxVal = Math.max(node.val, Math.max(left.max, right.max));

        
        result = Math.max(result, Math.max(Math.abs(node.val - minVal), Math.abs(node.val - maxVal)));

        return new Pair(minVal, maxVal);
    }
}



