class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int prefix_max[] = new int[n];
        int suffix_max[] = new int[n];
        
        prefix_max[0] = height[0];
        for(int i=1 ;i<n; i++){
            prefix_max[i] = Math.max(prefix_max[i-1],height[i]);
        }

        
        suffix_max[n-1] = height[n-1];
        for(int j=n-2;j>=0;j--){
             suffix_max[j] = Math.max(suffix_max[j+1],height[j]);
        }

        int total = 0;
        for(int i=0; i<n; i++){
          int leftmax = prefix_max[i], rightmax = suffix_max[i];
          if(height[i] < leftmax && rightmax > height[i]){
               total += Math.min(leftmax,rightmax) - height[i];
          }
        }

        return total;

    }
}