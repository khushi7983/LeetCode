class Solution {
    public long coloredCells(int n) {
        // int t = 1;
        // long cells = 1;

        // while(t<= n){
        //     cells += (4 * (t-1));
        //     t++;
        // }
        //  return cells;


         long res = n;
         return 1 + (res-1)*res*2;  
    }

}