class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int i = 0;
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int j=0; j<n; j++){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);


            while (map.getOrDefault('a', 0) > 0 &&
                   map.getOrDefault('b', 0) > 0 &&
                   map.getOrDefault('c', 0) > 0) {

                   count += n - j;
                    char leftChar = s.charAt(i);
                    map.put(leftChar, map.get(leftChar) - 1);
                    i++;
            
            }

        }
        return count;
    }
}