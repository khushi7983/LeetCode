class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
         List<Integer> ds = new ArrayList<>();
        findCombination(0,candidates,target,ans,ds);
        return ans;
    }

    private void findCombination(int idx, int arr[], int target, List<List<Integer>> ans,List<Integer> ds){
        if(idx == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

            if(arr[idx] <= target){
                 ds.add(arr[idx]);
                 findCombination(idx,arr,target-arr[idx],ans,ds);
                 ds.remove(ds.size()-1);
            }
            findCombination(idx + 1, arr, target, ans, ds);
    }

}