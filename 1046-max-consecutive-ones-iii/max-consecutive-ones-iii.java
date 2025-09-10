class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int max  = 0;

        for(int j = 0; j < n; j++){
            
            if(arr[j] == 0){
                k--;
            }

            while (k < 0) {
                if (arr[i] == 0) {
                    k++; 
                }
                i++;
            }

            max = Math.max(max , j - i + 1);
        }

        return max;
        
    }
}