class Solution {
    public int minimumOperations(int[] numsArr) {
        int n = numsArr.length;
        List<Integer> nums = new ArrayList<>();
        for (int num : numsArr) nums.add(num);

        int ops = 0;

        for (int i = 0; i < n; i += 3) {
            Set<Integer> set = new HashSet<>();
            boolean allDistinct = true;

            for (int j = i; j < n; j++) {
                if (set.contains(nums.get(j))) {
                    allDistinct = false;
                    break;
                }
                set.add(nums.get(j));
            }

            if (allDistinct) {
                return ops;
            }

            ops++;
        }

        return ops;
    }
}