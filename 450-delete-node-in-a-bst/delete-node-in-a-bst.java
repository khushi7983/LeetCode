class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // CASE 1: No child
            if (root.left == null && root.right == null) return null;

            // CASE 2: One child
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // CASE 3: Two children → use inorder predecessor
            else {
                TreeNode pred = findPred(root.left);
                root.val = pred.val;  // copy predecessor value
                // delete predecessor from left subtree
                root.left = deleteNode(root.left, pred.val);
            }
        }
        return root;
    }

    private TreeNode findPred(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
