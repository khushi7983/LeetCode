class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
             
          int j ;
          for( j = i+1 ; j<n; j++){
            if(intervals[j][0] <= end ){
                end = Math.max(end, intervals[j][1]);
            }
            else{
                break;
            }

         }
            ans.add(Arrays.asList(start, end));
            i = j - 1;
         
        }
            // Convert List<List<Integer>> to int[][]
         int[][] merged = new int[ans.size()][2];
          for (int j = 0; j < ans.size(); j++) {
          merged[j][0] = ans.get(j).get(0);
          merged[j][1] = ans.get(j).get(1);
          }
       

        return merged;

    }
}