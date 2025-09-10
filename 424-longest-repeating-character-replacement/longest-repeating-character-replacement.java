class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0, maxlen = 0, maxfreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(c));

            // Number of replacements needed = window length - maxfreq --> Number of replacements needed = window length - maxfreq

            while ((j - i + 1) - maxfreq > k) {
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                i++;
            }

            maxlen = Math.max(maxlen, j - i + 1);
        }

        return maxlen;
    }
}
