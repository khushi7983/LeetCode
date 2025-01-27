class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        if(n==0){
           return "";
        }
        if(n==1){
            return strs[0];
        }
        String str1 =  strs[0];
        String str2 =  strs[n-1];
        int index = 0;
        while(index < str1.length()){
            if(str1.charAt(index) == str2.charAt(index)){
                index++;
            }
            else{
                break;
            }
        }

        return str1.substring(0,index);
        
    }
}