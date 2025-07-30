import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> merged = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart <= end) {
                end = Math.max(end, currEnd);
            } else {
                merged.add(Arrays.asList(start, end));
                start = currStart;
                end = currEnd;
            }
        }

        merged.add(Arrays.asList(start, end)); // Add the last one

        // Convert List<List<Integer>> to int[][]
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i][0] = merged.get(i).get(0);
            result[i][1] = merged.get(i).get(1);
        }

        return result;
    }
}
