class Solution {
    public int myAtoi(String s) {
        int sign = 1, result = 0;
        int INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
        boolean started = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

     
            if (!started && ch == ' ') continue;

          
            if (!started && (ch == '+' || ch == '-')) {
                sign = (ch == '-') ? -1 : 1;
                started = true;
                continue;
            }

          
            if (Character.isDigit(ch)) {
                started = true;
                int digit = ch - '0';

                
                if (result > (INT_MAX - digit) / 10) {
                    return (sign == 1) ? INT_MAX : INT_MIN;
                }

                result = result * 10 + digit;
            } else {
                break; 
            }
        }

        return sign * result;
    }
}
