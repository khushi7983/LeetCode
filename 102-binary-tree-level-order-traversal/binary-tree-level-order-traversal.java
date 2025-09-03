class Solution {
    public static int height(TreeNode root){
        if(root == null) return -1  ;
        if(root.left == null && root.right == null) return 0 ;
        return 1 + Math.max(height(root.left) , height(root.right));
    }
    public static List<Integer>  nthlevel(TreeNode root , int n ){
        List<Integer> result = new ArrayList<>();

        if(root == null) return result  ;
        if(n==1 ) result.add(root.val);
        else {
            result.addAll(nthlevel(root.left, n - 1));
            result.addAll(nthlevel(root.right, n - 1));
        }
        return result ;

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> levels = new ArrayList<>();
        int h = height(root) + 1; // number of levels

        for (int i = 1; i <= h; i++) {
            levels.add(nthlevel(root, i));
        }

        return levels;
        
    }
}