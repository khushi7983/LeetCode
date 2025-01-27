public class Solution {
    public String frequencySort(String s) {
      
        int[] freq = new int[126];
        
     
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < 126; i++) {
            if (freq[i] > 0) {
                characters.add((char) i);
            }
        }
        
     
        characters.sort((a, b) -> freq[b] - freq[a]);
        
        
        StringBuilder result = new StringBuilder();
        for (char c : characters) {
            int count = freq[c];
            while (count-- > 0) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
