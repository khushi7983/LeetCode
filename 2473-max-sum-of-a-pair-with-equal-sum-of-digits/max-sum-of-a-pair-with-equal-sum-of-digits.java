class Solution {
    private int getDigitSum(int num) {
        int sum = 0;
        
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        
        return sum;
    }
    
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int result = -1;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int digitSum = getDigitSum(nums[i]);
            
            if (map.containsKey(digitSum)) {
                result = Math.max(result, nums[i] + map.get(digitSum));
            }
            
            map.put(digitSum, Math.max(map.getOrDefault(digitSum, 0), nums[i]));
        }
        
        return result;
    }
}
