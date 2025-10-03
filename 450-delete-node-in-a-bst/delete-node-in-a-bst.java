class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            // CASE 1 : leaf node
            if(root.left == null && root.right == null) return null;
            // CASE 2 : one child
            else if(root.left == null || root.right == null){
                if(root.left == null) return root.right;
                else return root.left;
            }
            
            // CASE 3 Both child --> replace pred with key node
            else{
                TreeNode pred = inorderPredessor(root);
                TreeNode predParent = parent(root,pred);

                if(root == predParent) { 
                pred.right = root.right;
                return pred;
                } 
                
                predParent.right = pred.left;
                pred.left = root.left;
                pred.right = root.right;

               return pred;

            }

        }
        else if(root.val < key){
            // change in RST
          root.right =  deleteNode(root.right,key);
        }
        else{
            // change in LST
          root.left =  deleteNode(root.left,key);
        }
        
        return root;
    }
    public TreeNode inorderPredessor(TreeNode root){
        TreeNode temp = root.left;
        while(temp.right != null) temp = temp.right;
        return  temp;
    }

    public TreeNode parent(TreeNode root,TreeNode pred){
        if(root.left == pred || root.right == pred) return root;
        TreeNode temp = root.left;
        while(temp.right != pred) temp = temp.right;
        return temp;
    }
}