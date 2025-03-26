class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] flatArr = Arrays.stream(grid).flatMapToInt(Arrays::stream).toArray();
        
        Arrays.sort(flatArr);
        int remainder = flatArr[0] % x;
        int count = 0;
        for(int i=0; i<flatArr.length; i++){
            if(flatArr[i]%x != remainder){
                return -1;
            }
            int median = flatArr[flatArr.length / 2];
            count += Math.abs(flatArr[i] - median) / x;
        }

        return count;

    }
}