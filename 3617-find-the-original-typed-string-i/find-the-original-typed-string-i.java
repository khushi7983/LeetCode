class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();

        // HashMap<Character,Integer> = new HashMap<>();
        int count = 0;
        for(int i=0; i<n; i++){
            
            int j = i+1;
            if(j<n){

                if(word.charAt(j) == word.charAt(i)){
                 count ++;
                }
                j++;
            }
             
        }  
        return count + 1;


        
    }
}