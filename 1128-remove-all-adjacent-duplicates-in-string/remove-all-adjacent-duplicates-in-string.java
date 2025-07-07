class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (!st.isEmpty() && st.peek() == ch) {
                st.pop(); // remove adjacent duplicate
            } else {
                st.push(ch);
            }
        }

        StringBuilder str = new StringBuilder();

        while (!st.isEmpty()) {
            str.append(st.pop());
        }

        str.reverse(); 
        return str.toString();
    }
}
