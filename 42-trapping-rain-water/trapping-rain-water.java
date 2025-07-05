class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int i = 0;
        int j = n-1;

        int leftmax = 0;
        int  rightmax = 0, total = 0;
        while(i < j){
             if(height[i] < height[j]){
                if(height[i] >= leftmax){
                    leftmax = height[i];
                }
                else {
                    total += leftmax - height[i];
                }
                i++;
             }
             else{
                if (height[j] >= rightmax) {
                    rightmax = height[j];
                } else {
                    total += rightmax - height[j];
                }
                j--;
            }
        }
        return total;

    }
}