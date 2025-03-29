class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int smaller = 0, equal = 0, greater = 0;

        // Count occurrences
        for (int num : nums) {
            if (num < pivot) smaller++;
            else if (num == pivot) equal++;
            else greater++;
        }

        // Fill result array
        int i = 0;
        for (int num : nums) {
            if (num < pivot) result[i++] = num;
        }
        for (int num : nums) {
            if (num == pivot) result[i++] = num;
        }
        for (int num : nums) {
            if (num > pivot) result[i++] = num;
        }

        return result;
    }
}
