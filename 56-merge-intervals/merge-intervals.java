class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> merged = new ArrayList<>();

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];

                if (merged.isEmpty() || merged.get(merged.size() - 1).get(1) < start) {
                    merged.add(new ArrayList<>(List.of(start, end)));
                } else {
                    List<Integer> last = merged.get(merged.size() - 1);
                    last.set(1, Math.max(last.get(1), end));
                }
            }

        // Convert List<List<Integer>> to int[][]
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i][0] = merged.get(i).get(0);
            result[i][1] = merged.get(i).get(1);
        }

        return result;
    }
}
