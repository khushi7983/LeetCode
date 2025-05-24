class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> ds =  new ArrayList<>();
      boolean freq[] = new boolean[n+1];
      permutation(nums,ans,ds,freq);
      return ans;
    }
    private void permutation(int[] nums,List<List<Integer>> ans,List<Integer> ds,boolean freq[]){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                ds.add(nums[i]);            // add
                freq[i] = true;             // mark

                permutation(nums,ans,ds,freq);   //backtrack 
                ds.remove(ds.size()-1);         // remove
                freq[i] = false;                //unmark
            }

        }
    }
}