import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr); 
        int longest = 1;  
        int currentStreak = 1;

        for (int i = 1; i < arr.length; i++) {
           
            if (arr[i] == arr[i - 1]) {
                continue;
            }
           
            if (arr[i] == arr[i - 1] + 1) {
                currentStreak++;
            } 
            else {
                longest = Math.max(longest, currentStreak);
                currentStreak = 1;
            }
        }
        return Math.max(longest, currentStreak);
    }
}