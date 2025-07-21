class Solution {
    public String makeFancyString(String s) {
        int n = s.length();

        int count  = 0;
        StringBuilder ans  = new StringBuilder();

        for(int i=0; i<n-2; i++){

            if(s.charAt(i) == s.charAt(i+1) && s.charAt(i+1) == s.charAt(i+2)){
                continue;
            }
            else{
                ans.append(s.charAt(i));
            }

          

         
        }
        if(n>=2) ans.append(s.charAt(n-2));
        if(n>=1)  ans.append(s.charAt(n-1));
        return ans.toString();
    }
}