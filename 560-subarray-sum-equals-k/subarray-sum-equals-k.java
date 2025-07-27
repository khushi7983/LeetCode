// import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();

        // base case: sum = 0 exists once
        prefixSumFreq.put(0, 1);

        for (int num : nums) {
            sum += num;

            // check if there is a prefix sum that makes sum - k
            if (prefixSumFreq.containsKey(sum - k)) {
                count += prefixSumFreq.get(sum - k);
            }

            // store current sum frequency
            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
