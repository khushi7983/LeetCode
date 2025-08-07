class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);  
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEatAll(piles, mid, h)) {
                result = mid;       
                high = mid - 1;
            } else {
                low = mid + 1;     
            }
        }

        return result;
    }

    //  get max value 
    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    //  if Koko can eat all bananas at speed k in h hours
    private boolean canEatAll(int[] piles, int k, int h) {
        long totalHours = 0; // use long to avoid overflow
        for (int pile : piles) {
            totalHours += (pile + k - 1) / k; // same as Math.ceil(pile / k)
        }
        return totalHours <= h;
    }
}
