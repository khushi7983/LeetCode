class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int levelNum = 0; 

        while (!q.isEmpty()) {
            int size = q.size();
            Deque<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (levelNum % 2 == 0) {  
                    level.addLast(node.val);
                } else {                   
                    level.addFirst(node.val);
                }

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            ans.add(new ArrayList<>(level));
            levelNum++; 
        }

        return ans;
    }
}
