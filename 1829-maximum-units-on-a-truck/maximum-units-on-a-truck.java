class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int maxUnits = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int noOfBoxes = boxTypes[i][0];
            int UnitsPerBox = boxTypes[i][1];
            
           if( truckSize >= noOfBoxes ){
                maxUnits += noOfBoxes*UnitsPerBox;
                truckSize -= noOfBoxes;
           }
           else{
              maxUnits += truckSize*UnitsPerBox;
               break;
           } 
        }
        return maxUnits;   
    }
}