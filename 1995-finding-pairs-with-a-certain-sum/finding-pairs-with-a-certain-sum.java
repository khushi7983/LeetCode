class FindSumPairs {
        int[] nums1;
        int[] nums2;
        Map<Integer, Integer> freq;
    public FindSumPairs(int[] nums1, int[] nums2) {
       this.nums1 = nums1;
       this.nums2 = nums2;
       freq = new HashMap<>();
       for(int i=0; i<nums2.length; i++){
         freq.put(nums2[i],freq.getOrDefault(nums2[i],0)+1);
       }
    }
    
    public void add(int index, int val) {
        
        int oldVal = nums2[index];

      // Step 1: Remove old value from freq map
      freq.put(oldVal, freq.get(oldVal) - 1);
      if (freq.get(oldVal) == 0) {
        freq.remove(oldVal); // optional: clean up
      }

     // Step 2: Update the actual array
     nums2[index] += val;

     int newVal = nums2[index];

     // Step 3: Add new value to freq map
     freq.put(newVal, freq.getOrDefault(newVal, 0) + 1);
    }
    
    public int count(int tot) {

        int count = 0;
        for (int num : nums1) {
        int required = tot - num;
        count += freq.getOrDefault(required, 0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */