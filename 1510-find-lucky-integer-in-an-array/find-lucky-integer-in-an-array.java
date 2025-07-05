class Solution {
    public int findLucky(int[] arr) {
       int n = arr.length;
       HashMap<Integer,Integer> map = new HashMap<>(); 
       
       int luckyNo = -1;
       for(int i=0; i<n; i++){
        map.put(arr[i],map.getOrDefault(arr[i],0)+1);
       }
       for(int i=0; i<n; i++){
         if(map.get(arr[i]) == arr[i]){
            luckyNo = Math.max(luckyNo,arr[i]);
         }
       }

       return luckyNo;
    }
}