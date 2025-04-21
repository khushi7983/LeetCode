class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) -> (a[1]<=b[1])?-1:1);

        int arrows = 1;
        int lastpoint = points[0][1];

        for( int i=1; i<points.length; i++){
            // no overlap
            if(points[i][0] > lastpoint ){
                arrows++;
                lastpoint =points[i][1];
            }
         
        }
        return arrows;
    }
}