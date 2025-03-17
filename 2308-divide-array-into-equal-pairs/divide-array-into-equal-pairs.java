class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
          
        // Count frequency of each number
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Check if all frequencies are even
        for (int key : map.keySet()) { // Iterate over unique keys
            if (map.get(key) % 2 != 0) {
                return false;
            }
        }

        return true;

    }   
}