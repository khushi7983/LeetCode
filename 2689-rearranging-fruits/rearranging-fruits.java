class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : basket1) freq.put(x, freq.getOrDefault(x, 0) + 1);
        for (int x : basket2) freq.put(x, freq.getOrDefault(x, 0) - 1);

        List<Integer> excess = new ArrayList<>();
        int globalMin = Integer.MAX_VALUE;

        for (int key : freq.keySet()) {
            int val = freq.get(key);
            if (val % 2 != 0) return -1; // Impossible
            globalMin = Math.min(globalMin, key);
            for (int i = 0; i < Math.abs(val) / 2; i++) {
                excess.add(key);
            }
        }

        Collections.sort(excess);
        int n = excess.size();
        long cost = 0;
        for (int i = 0; i < n / 2; i++) {
            cost += Math.min(excess.get(i), 2 * globalMin);
        }
        return cost;
    }
}