class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashSet<Character> letters = new HashSet<>();

        for(int i=0; i<n; i++){
            letters.add(s.charAt(i));
        }
        int result  = 0;

        for(int letter : letters){
            int firstIdx  = -1;
            int lastIdx = -1;

            for(int i = 0; i<n; i++){
                if(s.charAt(i) == letter){
                    if(firstIdx == -1){
                        firstIdx = i;
                    }
                    else{
                        lastIdx = i;
                    }
                } 
            }
            HashSet<Character> st = new HashSet<>();
            for(int middle = firstIdx+1; middle <= lastIdx -1; middle++){
                st.add(s.charAt(middle)); 
            }
            
            result += st.size();
        }

        return result;
        
    }
}