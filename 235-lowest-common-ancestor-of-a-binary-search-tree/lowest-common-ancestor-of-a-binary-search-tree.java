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
    HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, null, p, q);
        
        // Collect ancestors of p
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }
        
        while (q != null) {
            if (ancestors.contains(q)) {
                return q;  // LCA found
            }
            q = parentMap.get(q);
        }

        return null; // should not happen if both p and q are in tree
            
        
    }
    public void dfs(TreeNode node, TreeNode parent, TreeNode p, TreeNode q){
        if(node == null) return;

        if(parent != null){
            parentMap.put(node,parent);
        }
        // if both found 
        if (parentMap.containsKey(p) && parentMap.containsKey(q)) {
            return;
        }
         
        dfs(node.left,node,p,q);
        dfs(node.right,node,p,q);

        
    }

}