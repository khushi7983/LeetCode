class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        if (root.left != null && root.val <= max(root.left)) {
            return false;
        }

        if (root.right != null && root.val >= min(root.right)) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public int max(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int leftMax = max(root.left);
        int rightMax = max(root.right);
        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    public int min(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int leftMin = min(root.left);
        int rightMin = min(root.right);
        return Math.min(root.val, Math.min(leftMin, rightMin));
    }
}
