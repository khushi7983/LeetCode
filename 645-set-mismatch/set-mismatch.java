class Solution {
    public int[] findErrorNums(int[] nums) {
      
      int n = nums.length;

      int ans[] = new int[2];
      HashMap<Integer,Integer> map = new HashMap<>();

      
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                ans[1] = i;
            } else if (map.get(i) == 2) {
                ans[0] = i; 
            }
        }

      return ans;  
    }
}