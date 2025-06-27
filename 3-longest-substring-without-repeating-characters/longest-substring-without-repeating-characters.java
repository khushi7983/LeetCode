class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left=0;
        int right=0;
        int maxlen = 0;

        Set<Character> set = new HashSet<Character>();

        while(right<n){
            char c = s.charAt(right);
            if(!set.contains(c)){
                set.add(c);
                int len = right - left + 1;
                maxlen = Math.max(maxlen,len);
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxlen;
    }
}