class Solution {
    public int maxFreqSum(String s) {
        int n  = s.length();
        HashMap<Character,Integer> map = new HashMap<>();

        int maxConst = 0;
        int maxVowel = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

        
                if(isVowel(ch) && map.get(ch) > maxVowel){
                    maxVowel = map.get(ch);
                }

                if(!isVowel(ch) && map.get(ch) > maxConst){
                    maxConst = map.get(ch);
                }
                
        }
       return (maxConst + maxVowel);     
    }
    
    public boolean isVowel(char ch){
        if(ch == 'a'||  ch == 'e' || ch == 'i'|| ch == 'o'|| ch == 'u'){
            return true;
        }
        else{
            return false;
        }
    }
}