class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int max = 0;

        // if(n  == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        for(int j = 0; j < n ; j++){
            char c = s.charAt(j);

            while(set.contains(c)){
                set.remove(s.charAt(i));
                i++;

            }

            set.add(c);
            max = Math.max(max,j - i + 1);


        }

        return max;
    
        
    }
}