class Solution {
    public int reverse(int x) {
        int rev=0;
        int lastDigit=0;
        int n=x;
        while(n!=0){
            lastDigit=n%10;
            if (rev > Integer.MAX_VALUE/10 || rev < Integer.MIN_VALUE/10) {
            return 0; 
            }
            rev=(rev*10)+lastDigit;
            n=n/10;
        }
        return rev;
    }
}