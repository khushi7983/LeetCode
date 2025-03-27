class Solution {
    public int minimumIndex(List<Integer> nums) {
       int n = nums.size();
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        
        for(int num : nums){
            map2.put(num,map2.getOrDefault(num,0)+1);
        }
        for( int i=0; i<n; i++){
            int num = nums.get(i);

            map1.put(num,map1.getOrDefault(num,0)+1);
            map2.put(num,map2.get(num)-1);

            int n1 = i+1;
            int n2 = n-i-1;

            if(map1.get(num) > n1/2 && map2.get(num) > n2/2){
                return i;
            }
        }
        return -1;
       
    }
}