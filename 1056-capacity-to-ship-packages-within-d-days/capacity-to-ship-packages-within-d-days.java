class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n  =  weights.length;

        int l = Integer.MIN_VALUE, r = 0;
        for (int i = 0; i < weights.length; i++) {
            r += weights[i];
            l = Math.max(l, weights[i]);
        }
         
        int ans = r;
        while( l <= r){
            int mid = l + (r - l)/2;
            if(minDay(weights,mid) <= days){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
        
    }
    public int minDay(int[] weights, int cap){
        int day  = 1; int load = 0;
        for(int  i= 0; i<weights.length; i++){
            if(load + weights[i] > cap){
                day  = day + 1;
                load = weights[i]; 
            }
            else{
                load += weights[i];
            }
        }
        return day;
    }
}