// class Solution {
//     public String longestPalindrome(String s) {
//     // int n = s.length();
//     HashMap<Character,Integer> freqMap = new HashMap<>();
//     int result = 0;
//     int oddCount = 0;
//     for(char ch : s.toCharArray()){
//          freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
//          int currentFreq = freqMap.get(ch);
//          if(currentFreq%2 == 0){
//             result += 2;
//              oddCount--;

//          }
//         else{
//              oddCount++;

//         }

//     }
//     if(oddCount > 0){
//         result+= 1;
//     }
//     return result;
//     }
// }

class Solution {
    public int longestPalindrome(String s) {
        int[] charCounts = new int[128]; // Assuming ASCII characters
        int oddCount = 0;

        for (char c : s.toCharArray()) {
            charCounts[c]++;
            if (charCounts[c] % 2 == 1) {
                oddCount++;
            } else {
                oddCount--;
            }
        }

        return (oddCount > 0) ? s.length() - oddCount + 1 : s.length();
    }
}