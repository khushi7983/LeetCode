class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
           if (i > 0 && nums[i] == nums[i - 1]) continue;


            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                  List<Integer> triplet = Arrays.asList(nums[i],nums[j],nums[k]);
                  result.add(triplet);

                   int valJ = nums[j];
                    int valK = nums[k];

                    while (j < k && nums[j] == valJ) j++;
                    while (j < k && nums[k] == valK) k--;


                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
