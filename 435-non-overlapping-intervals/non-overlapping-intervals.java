class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int overlapping = 0; 
        int lastEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < lastEnd) {
                overlapping++;  
            }
            else{
                lastEnd = intervals[i][1];
            }
        }

        return overlapping;
    }
}