class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int maj = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            map.put(nums[i] ,map.getOrDefault(nums[i],0) + 1);
            if(map.get(nums[i]) > n/2) {
                maj = nums[i];
            } 
        }

        return maj;
    }
}