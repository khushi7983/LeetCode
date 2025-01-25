class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char arrA[] = s.toCharArray();
        char arrB[] = t.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int indexA = 0;
        int indexB = 0;
        int n = arrA.length;
        while( indexA < n && indexB < n ){
            if(arrA[indexA] != arrB[indexB]){
               return false;
            }
            indexA++;
            indexB++;
        }
        return true;
    }
}