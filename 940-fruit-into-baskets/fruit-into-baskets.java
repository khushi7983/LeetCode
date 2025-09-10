class Solution {
    public int totalFruit(int[] fruits) {
        
        //you want the length of the longest contiguous subarray that contains at most two distinct values (fruit types).

        int n = fruits.length;
        int i = 0;
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();


        for(int  j = 0; j<n; j++){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);

            while(map.size() > 2){

                map.put(fruits[i],map.get(fruits[i]) - 1);

                if (map.get(fruits[i]) == 0) {
                map.remove(fruits[i]);
                }
                
                i++;
            
            }

            max = Math.max(max, j - i + 1);
            
        }
        return max;
    }
}