class Solution {
    public boolean isPossible(int ranks[] , long mid , int cars){
        long carsFixed  = 0;
        for(int i = 0; i<ranks.length; i++){
             carsFixed += (long) Math.sqrt(mid/ranks[i]);
        }
        return carsFixed >= cars;

    }
    public long repairCars(int[] ranks, int cars) {
        int maxR = 0;
        for(int i=0 ;  i<ranks.length; i++){
           if(ranks[i] > maxR){
            maxR = ranks[i];
           }
        }
        long result = -1;
        long l = 1;
        long r = (long) maxR * cars * cars ;
        while( l <= r ){
            long mid =   l + ( r - l)/2;
            if(isPossible(ranks , mid , cars)== true){
                 result = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return result;
    }
}