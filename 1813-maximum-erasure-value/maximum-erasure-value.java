class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int n = nums.length;
        int i = 0;
        int maxSum = 0;
        int sum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int j = 0; j<n; j++){

            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                sum += nums[j];

            while(map.get(nums[j]) > 1){
                map.put(nums[i], map.get(nums[i]) - 1);
                sum = sum - nums[i];
                i++;
            }

            maxSum = Math.max(sum,maxSum);


        }  

        return maxSum;     
    }
}