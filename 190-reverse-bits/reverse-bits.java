public class Solution {
    public int reverseBits(int n) {
        int i = 0;
        int j = 31;

        while( i<j){
            int mask1 = (1 << i);
            int mask2 = (1 << j);
            
            boolean iOn = (( n & mask1) != 0);
            boolean jOn = (( n & mask2) != 0);
    
            if (iOn != jOn) { 
                n ^= mask1;
                n ^= mask2;
            }
            
            i++;
            j--;

        }

        return n ;
    }
}