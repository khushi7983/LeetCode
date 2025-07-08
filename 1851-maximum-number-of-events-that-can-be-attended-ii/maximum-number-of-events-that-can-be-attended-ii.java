import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        int dp[][] = new int[n][k+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        return f(0, k, events,dp);

    }


    public int f(int i, int k, int[][] events, int dp[][]) {
        int n = events.length;
        if (k == 0 || i == n) return 0;
         
        if(dp[i][k] != -1) return dp[i][k];

        int notAttend = f(i + 1, k, events ,dp);

        // Attend 
        int nextIndex = findNext(events, events[i][1]);
        int attend = events[i][2] + f(nextIndex, k - 1, events ,dp);

        return dp[i][k] = Math.max(attend, notAttend);
    }

    // Find the next index with startDay > current endDay using binary search
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
