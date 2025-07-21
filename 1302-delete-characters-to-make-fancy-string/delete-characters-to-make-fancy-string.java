class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if (n < 3) return s;

        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));

        int count = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count < 3) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
