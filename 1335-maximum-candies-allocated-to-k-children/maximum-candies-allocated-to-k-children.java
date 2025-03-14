// class Solution {
//     public int maximumCandies(int[] candies, long k) {
//         int n = candies.length;

//         int maxC = 0;
//         int total = 0;
//         for( int i=0 ; i<n ; i++){
//             total += candies[i];
//             if(candies[i] > maxC){
//                 maxC = candies[i];
//             }
//         }
//         if(total < k){
//             return 0;
//         }

//         // Brute force try from maxC
//         for( int c  = maxC; c>= 1; c--){
//             long count = 0;

//             for( int i=0 ; i<candies.length; i++){
//                 count += candies[i]/c;            
//             }
//             if(count >= k){
//                 return c;
//             }

//         }
//         return 0;
//     }
// }


class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1, high = 0;
        
        // Find the maximum candies in a single pile (maxC)
        for (int c : candies) {
            high = Math.max(high, c);
        }

        int result = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long count = 0;

            // Calculate how many children can get 'mid' candies each
            for (int c : candies) {
                count += c / mid;
            }

            if (count >= k) { 
                // We can distribute 'mid' candies, try for a larger value
                result = mid;
                low = mid + 1;
            } else {
                // We can't distribute 'mid' candies, try a smaller value
                high = mid - 1;
            }
        }

        return result;
    }
}
