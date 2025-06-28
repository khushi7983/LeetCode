class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxlen = 0;
        int i = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int maxfreq = 0; 
        for(int j=0; j<n; j++){
           map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
           maxfreq = Math.max(maxfreq,map.get(s.charAt(j)));

        //    int changes = (j-i+1) - maxfreq;

           while( (j-i+1) - maxfreq > k){
            //  map.remove(s.charAt(i));
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
             i++;
            }
            maxlen = Math.max(maxlen,j-i+1);
            
        }

        return maxlen;
    }
}