class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
    
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        combination(1,k,n,ds,ans);
        return ans;
    }

    private void combination(int start, int k, int n ,List<Integer> ds ,List<List<Integer>> ans){
       // base case - if the size is k and sum is target, we found a combination
       if(ds.size()== k && n == 0){
          ans.add(new ArrayList<>(ds));
         return;
       }
       
       
        if(ds.size() < k){
          for(int i=start; i<=9; i++){
          ds.add(i);
          combination(i+1,k,n-i,ds,ans);
          ds.remove(ds.size()-1);
          }
        }

    }
}