
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int Q = queries.length;
        int[] result = new int[Q];

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];

        // Store query indices before sorting
        int[][] indexedQueries = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            indexedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(indexedQueries, (a, b) -> Integer.compare(a[0], b[0])); // Sort queries by value

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0}); // Start from top-left corner
        visited[0][0] = true;

        int count = 0; // Number of points collected
        int maxProcessedValue = 0; // Keep track of processed values

        for (int[] query : indexedQueries) {
            int queryVal = query[0], index = query[1];

            // Expand the grid while values are less than the query
            while (!pq.isEmpty() && pq.peek()[0] < queryVal) {
                int[] cell = pq.poll();
                int val = cell[0], i = cell[1], j = cell[2];
                count++;

                for (int[] dir : directions) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                        pq.offer(new int[]{grid[ni][nj], ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }
            
            result[index] = count;
        }

        return result;
    }
}
