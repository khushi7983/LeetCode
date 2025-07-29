import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        
        Arrays.sort(nums); 

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Long> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = 1L * nums[i] + nums[j] + nums[k]; // Use long to avoid overflow
                    long fourth = target - sum;
                    
                    if (set.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(temp); // Sort to handle different orders of same values
                        ans.add(temp);
                    }
                    set.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
