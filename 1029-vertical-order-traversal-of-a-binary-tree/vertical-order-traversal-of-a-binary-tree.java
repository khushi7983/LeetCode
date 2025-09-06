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
   
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        // DFS fill map
        dfs(root, 0, 0);

        // Traverse map
        for (TreeMap<Integer, List<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (List<Integer> nodes : rows.values()) {
                Collections.sort(nodes); // sort values at same row/col
                colList.addAll(nodes);
            }
            ans.add(colList);
        }

        return ans;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) return;

        // Put value in map[col][row]
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new ArrayList<>());
        map.get(col).get(row).add(node.val);

        // Left and Right traversal
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}
