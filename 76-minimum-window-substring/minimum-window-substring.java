import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n < m) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int minlen = Integer.MAX_VALUE; 
        int sIdx = -1;
        int count = 0;

        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {  
                    count++;
                }
            }

            // Shrink window only when it's valid
            while (count == m) {
                if (j - i + 1 < minlen) {
                    minlen = j - i + 1;
                    sIdx = i;
                }

                char startChar = s.charAt(i);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        count--;
                    }
                }

                i++; 
            }
        }

        return (sIdx == -1) ? "" : s.substring(sIdx, sIdx + minlen);  
    }
}
