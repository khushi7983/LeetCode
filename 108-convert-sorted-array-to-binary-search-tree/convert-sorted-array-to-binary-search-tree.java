class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode ans  = hepler(nums,0,n-1);
        return ans;
        
    }
    public TreeNode hepler(int[] nums, int l , int h ){
            if (l > h) return null; 
            int mid = (l + h)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = hepler(nums,l,mid-1);
            root.right = hepler(nums,mid+1,h);
            return root;
    }
}