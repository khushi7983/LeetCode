class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int n = nums.length;
        int ans = -1;

        for(int i = 0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

            if(map.get(nums[i]) > 1) {
               ans =  nums[i];
            }
        }

        return ans;

        
    }
}