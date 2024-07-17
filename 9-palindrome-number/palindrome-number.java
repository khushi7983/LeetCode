class Solution {
    public boolean isPalindrome(int x) {
       if (x < 0) {
            return false;
        }
        int original = x;
        int reversedNum = 0;
        while (x != 0) {
            int remainder = x % 10;
            reversedNum = reversedNum * 10 + remainder;
            x /= 10;
        }
        return original == reversedNum;
    }
        
    
}