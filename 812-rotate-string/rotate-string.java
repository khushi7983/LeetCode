class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        char[] A = s.toCharArray();
        char[] B = goal.toCharArray();
        int n = A.length;

        for (int i = 0; i < n; i++) {
           
            char last = A[n - 1];
            for (int j = n - 1; j > 0; j--) {
                A[j] = A[j - 1];
            }
            A[0] = last;

            // Check if A matches B
            if (arraysEqual(A, B)) {
                return true;
            }
        }

        return false;
    }
    private boolean arraysEqual(char[] A, char[] B) {
        if (A.length != B.length) {
            return false;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }
}
