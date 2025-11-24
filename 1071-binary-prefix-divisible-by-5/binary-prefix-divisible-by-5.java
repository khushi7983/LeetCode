class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum = (sum * 2 + nums[i]) % 5;
            ans.add(sum == 0);
        }

        return ans;
    }
}
