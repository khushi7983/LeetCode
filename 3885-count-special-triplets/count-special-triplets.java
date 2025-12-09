class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1000000007;
        int n = nums.length;
        HashMap<Integer,Integer> leftMap = new HashMap<>();
        HashMap<Integer,Integer> rightMap = new HashMap<>();

        long result = 0;

        for(int i=0; i<n; i++){
            rightMap.put(nums[i],rightMap.getOrDefault(nums[i],0)+1);
        }

        for(int i=0; i<n; i++){
            rightMap.put(nums[i],rightMap.get(nums[i])-1);
            int left = leftMap.getOrDefault(nums[i]*2,0);
            int right = rightMap.getOrDefault(nums[i]*2,0);

            long add = (1L * left * right)%mod;
            result = (int)((result + add)%mod);
            // result =(result +(long) left * right)%mod;

            leftMap.put(nums[i], leftMap.getOrDefault(nums[i], 0) + 1);

            
        }
        
        return (int)result;
        
    }
}