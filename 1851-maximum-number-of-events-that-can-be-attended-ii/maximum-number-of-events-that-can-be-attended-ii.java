import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        
        int[][] dp = new int[n + 1][k + 1]; 

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {

               
                int notAttend = dp[i + 1][j];

                
                int nextIndex = findNext(events, events[i][1]);
                int attend = events[i][2] + dp[nextIndex][j - 1];

                dp[i][j] = Math.max(attend, notAttend);
            }
        }

        return dp[0][k];
    }

    private int findNext(int[][] events, int currEnd) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > currEnd) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
