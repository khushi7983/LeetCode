class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
         if (digits.length() == 0)
            return result;

        HashMap<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
       
        StringBuilder temp = new  StringBuilder();
        solve(0, digits, temp, mp, result);
        return result;
    }
    private void solve(int idx , String digits, StringBuilder temp ,  HashMap<Character, String> mp,List<String> result ){
        // base case 
        if(idx == digits.length()){
           result.add(temp.toString());
           return;
        }

        String letters = mp.get(digits.charAt(idx));
        
        for (char ch : letters.toCharArray()) {
            temp.append(ch);                          // Do
            solve(idx + 1, digits, temp, mp, result); // Recurse
            temp.deleteCharAt(temp.length() - 1);     // Undo
        }


    }
}