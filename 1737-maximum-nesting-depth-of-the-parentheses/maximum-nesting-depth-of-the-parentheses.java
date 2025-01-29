class Solution {
    public int maxDepth(String s) {
        int currentOpen = 0;
        int maxOpen = 0;
        int n = s.length();
        for(int i=0 ; i<n ; i++){
            if(s.charAt(i) == '('){
                currentOpen++;
            }
            else if(s.charAt(i) == ')'){
                currentOpen--;
            }
            maxOpen = Math.max(maxOpen , currentOpen);
            
        }

        return maxOpen;
    }

}